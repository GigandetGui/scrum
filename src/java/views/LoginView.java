/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.Serializable;
import java.security.Principal;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabeans.User;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import managedbeans.UserEJB;

@SessionScoped
@Named
public class LoginView implements Serializable {

    private static final long serialVersionUID = 3254181235309041386L;

    private static Logger log = Logger.getLogger(LoginView.class.getName());

    @Inject
    private UserEJB userEJB;

    private String email;
    private String password;

    private static User user;

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            request.login(email, password);
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", null));
            return "signin";
        }

        Principal principal = request.getUserPrincipal();

        this.user = userEJB.findUserById(principal.getName());

        log.info("Authentication done for user: " + principal.getName());

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("User", user);
        if (request.isUserInRole("rd")) {
//            return "/rd/privatepage?faces-redirect=true";
               return "toIndexPromotion";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return "signin";
        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            this.user = null;
            request.logout();
            // clear the session
            ((HttpSession) context.getExternalContext().getSession(false)).invalidate();
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
        }

        return "/signin?faces-redirect=true";
    }

    public static User getAuthenticatedUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
