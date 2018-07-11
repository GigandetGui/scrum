package managers;

import facades.CandidatFacade;
import facades.EntretienFacade;
import facades.ParcoursFacade;
import facades.PromotionFacade;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import javabeans.Candidat;
import javabeans.Entretien;
import javabeans.Parcours;
import javabeans.Promotion;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author LAMBERT Ludovic
 */
@ManagedBean
@SessionScoped
public class FormulaireCandidature implements Serializable {

    private Candidat leCandidat;
    private Entretien lEntretien;
    private Parcours leParcours;

    /*
    Formulaire
     */
    //Candidat
    @NotNull(message = "Champs 'Nom' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'Nom' inccorect !")
    private String nom;

    @NotNull(message = "Champs 'Prénom' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'Prénom' inccorect !")
    private String prenom;

    @NotNull(message = "Champs 'Rue' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'Rue' inccorect !")
    private String rue;

    @NotNull(message = "Champs 'Code Postal' obligatoire")
    @Size(min = 5, max = 6, message = "Taille du champs 'Code Postal' inccorect !")
    private String codePostal;

    @NotNull(message = "Champs 'Ville' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'Ville' inccorect !")
    private String ville;

    @NotNull(message = "Champs 'Date de naissance' obligatoire")
    @Size(min = 8, max = 10, message = "Taille du champs 'Date de naissance' inccorect !")
    private String dateDeNaissance; //TODO LocalDate

    @Size(min = 0, max = 14, message = "Taille du champs 'Téléphone fixe' inccorect !")
    private String tel;

    @NotNull(message = "Champs 'Téléphone Portable' obligatoire")
    @Size(min = 0, max = 14, message = "Taille du champs 'Téléphone Portable' inccorect !")
    private String portable;

    @NotNull(message = "Champs 'E-Mail' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'E-Mail' inccorect !")
    @Pattern(regexp = ".*@*\\..{2,3}", message = "E-Mail inccorrect !")
    private String email;

    private String secuSocial;

    //Projet
    private Promotion projet;

    //Etudes/ Situation professionnelle
    @NotNull(message = "Champs 'Diplome le plus récent' obligatoire")
    @Size(min = 3, max = 255, message = "Taille du champs 'Diplome le plus récent' inccorect !")
    private String actuelle;

    @NotNull(message = "Champs 'Etablissement (et lieu)' obligatoire")
    @Size(min = 3, max = 255, message = "Taille du champs 'Etablissement (et lieu)' inccorect !")
    private String etablissement;

    @NotNull(message = "Champs 'Etat du diplome' obligatoire")
    private Boolean diplome;

    private String commentaire;

    //Mobilité
    private Boolean permisB = false;
    private Boolean voiture = false;
    private Boolean permisA = false;
    private Boolean moto = false;
    private Boolean scooter = false;
    //Dossier Scolaire
    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Matières générales'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Matières générales'")
    private int ds1;

    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Matières techniques'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Matières techniques'")
    private int ds2;

    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Assiduité / Comportement'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Assiduité / Comportement'")
    private int ds3;

    private String observationScolaire;
    //Entretien
    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Ouverture d'esprit'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Ouverture d'esprit'")
    private int e1;

    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Aisance relationnelle, confiance en soi'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Aisance relationnelle, confiance en soi'")
    private int e2;

    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Choix du métier / connaissance de la formation'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Choix du métier / connaissance de la formation'")
    private int e3;

    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Connaissance de l'apprentissage et de ses contraintes'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Connaissance de l'apprentissage et de ses contraintes'")
    private int e4;

    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Degré de motivation'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Degré de motivation'")
    private int e5;

    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'pproche pour la recherche d'entreprise'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'pproche pour la recherche d'entreprise'")
    private int e6;

    @Min(value = 1, message = "Entrez une note entre 1 et 7 pour 'Prédispositions techniques'")
    @Max(value = 7, message = "Entrez une note entre 1 et 7 pour 'Prédispositions techniques'")
    private int e7;

    private String observationEntretien;
    //Conclusion
    private String conclusion;
    private String avis;

    /*
    Objets pour base
     */
    private List<Promotion> lesPromotions;
    @EJB
    private PromotionFacade promotionFacade;

    private Candidat leCadidatToEdit;
    @EJB
    private CandidatFacade candidatFacade;
    
    private Entretien unEntretientToAdd;
    @EJB
    private EntretienFacade entretienFacade;
    
    private Parcours unParcoursToAdd;
    @EJB
    private ParcoursFacade parcoursFacade;

    /*
    Getters et Setters
     */
    public Candidat getLeCandidat() {
        return leCandidat;
    }

    public void setLeCandidat(Candidat leCandidat) {
        this.leCandidat = leCandidat;
    }

    public Entretien getlEntretien() {
        return lEntretien;
    }

    public void setlEntretien(Entretien lEntretien) {
        this.lEntretien = lEntretien;
    }

    public Parcours getLeParcours() {
        return leParcours;
    }

    public void setLeParcours(Parcours leParcours) {
        this.leParcours = leParcours;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecuSocial() {
        return secuSocial;
    }

    public void setSecuSocial(String secuSocial) {
        this.secuSocial = secuSocial;
    }

    public Promotion getProjet() {
        return projet;
    }

    public void setProjet(Promotion projet) {
        this.projet = projet;
    }

    public String getActuelle() {
        return actuelle;
    }

    public void setActuelle(String actuelle) {
        this.actuelle = actuelle;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public Boolean getDiplome() {
        return diplome;
    }

    public void setDiplome(Boolean diplome) {
        this.diplome = diplome;
    }

    public List<Promotion> getLesPromotions() {
        try {
            lesPromotions = promotionFacade.findAll();
            return lesPromotions;
        } catch (EJBException ee) {
            return lesPromotions = new ArrayList<>();
        }
    }

    public void setLesPromotions(List<Promotion> lesPromotions) {
        this.lesPromotions = lesPromotions;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Boolean getPermisB() {
        return permisB;
    }

    public void setPermisB(Boolean permisB) {
        this.permisB = permisB;
    }

    public Boolean getVoiture() {
        return voiture;
    }

    public void setVoiture(Boolean voiture) {
        this.voiture = voiture;
    }

    public Boolean getPermisA() {
        return permisA;
    }

    public void setPermisA(Boolean permisA) {
        this.permisA = permisA;
    }

    public Boolean getMoto() {
        return moto;
    }

    public void setMoto(Boolean moto) {
        this.moto = moto;
    }

    public Boolean getScooter() {
        return scooter;
    }

    public void setScooter(Boolean scooter) {
        this.scooter = scooter;
    }

    public int getDs1() {
        return ds1;
    }

    public void setDs1(int ds1) {
        this.ds1 = ds1;
    }

    public int getDs2() {
        return ds2;
    }

    public void setDs2(int ds2) {
        this.ds2 = ds2;
    }

    public int getDs3() {
        return ds3;
    }

    public void setDs3(int ds3) {
        this.ds3 = ds3;
    }

    public String getObservationScolaire() {
        return observationScolaire;
    }

    public void setObservationScolaire(String observationScolaire) {
        this.observationScolaire = observationScolaire;
    }

    public int getE1() {
        return e1;
    }

    public void setE1(int e1) {
        this.e1 = e1;
    }

    public int getE2() {
        return e2;
    }

    public void setE2(int e2) {
        this.e2 = e2;
    }

    public int getE3() {
        return e3;
    }

    public void setE3(int e3) {
        this.e3 = e3;
    }

    public int getE4() {
        return e4;
    }

    public void setE4(int e4) {
        this.e4 = e4;
    }

    public int getE5() {
        return e5;
    }

    public void setE5(int e5) {
        this.e5 = e5;
    }

    public int getE6() {
        return e6;
    }

    public void setE6(int e6) {
        this.e6 = e6;
    }

    public int getE7() {
        return e7;
    }

    public void setE7(int e7) {
        this.e7 = e7;
    }

    public String getObservationEntretien() {
        return observationEntretien;
    }

    public void setObservationEntretien(String observationEntretien) {
        this.observationEntretien = observationEntretien;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    /*
    Fonctions 
     */
    public LocalDate stringToLocalDate(String unString) {
        try {
            DateTimeFormatter formatterFormulaireCandidature = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate laDate = LocalDate.parse(unString, formatterFormulaireCandidature);

            return laDate;
        } catch (Exception e) {
            return null; //TODO Trouvé quoi retourner ou retourner formulaire précédent.
        }
    }

    public void testLudovic() {
        System.out.println("Nom : " + this.nom);
        System.out.println("Prenom : " + this.prenom);
        System.out.println("Rue : " + this.rue);
        System.out.println("Code Postal : " + this.codePostal);
        System.out.println("Ville : " + this.ville);
        System.out.println("Date de naissance : " + stringToLocalDate(this.dateDeNaissance) + " : " + this.dateDeNaissance);
        System.out.println("Téléphone : " + this.tel);
        System.out.println("Portable : " + this.portable);
        System.out.println("Email : " + this.email);
        System.out.println("Sécurité Social : " + this.secuSocial);
        System.out.println("Diplome le plus récent : " + this.actuelle);
        System.out.println("Etablissement(et lieu) : " + this.etablissement);
        System.out.println("Etat du diplome : " + " + note : " + this.diplome);
        System.out.println("Permis voiture : " + this.permisB);
        System.out.println("Voiture : " + this.voiture);
        System.out.println("Permis Moto : " + this.permisA);
        System.out.println("Moto : " + this.moto);
        System.out.println("Scooter : " + this.scooter);
        System.out.println("Matières générales : " + this.ds1);
        System.out.println("Matières techniques : " + this.ds2);
        System.out.println("Assiduité / Comportement : " + this.ds3);
        System.out.println("Observation Dossier Scolaire : " + this.observationScolaire);
        System.out.println("Ouverture d'esprit : " + this.e1);
        System.out.println("Aisance relationelle, confiance en soi : " + this.e2);
        System.out.println("Choix du métier / connaissance de la formation : " + this.e3);
        System.out.println("Connaissance de l'apprentissage et de ses contraintes : " + this.e4);
        System.out.println("Degré de motivation : " + this.e5);
        System.out.println("Approche pour la recherche d'entreprise : " + this.e6);
        System.out.println("Prédispositions techniques : " + this.e7);
        System.out.println("Observation Entretien : " + this.observationEntretien);
        System.out.println("Conclusion : " + this.conclusion);
        System.out.println("Avis : " + this.avis);
    }

}
