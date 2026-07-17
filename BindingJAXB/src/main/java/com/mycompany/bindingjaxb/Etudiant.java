package com.mycompany.bindingjaxb;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "etudiant")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nom", "prenom", "filiere", "annee", "notes"})
public class Etudiant {

    @XmlAttribute
    private int id;

    @XmlElement(required = true)
    private String nom;

    private String prenom;
    private String filiere;
    private int annee;

    @XmlElementWrapper(name = "notes")
    @XmlElement(name = "note")
    private List<Double> notes;

    @XmlTransient
    private String motDePasse;

    // Constructeur vide obligatoire pour JAXB
    public Etudiant() {
    }

    // Constructeur avec paramètres
    public Etudiant(int id, String nom, String prenom,
                     String filiere, int annee, List<Double> notes) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.annee = annee;
        this.notes = notes;
    }

    // Méthode pour afficher les notes
    public void afficherNotes() {

        if (notes == null || notes.isEmpty()) {
            System.out.println("Aucune note");
            return;
        }

        System.out.println("Notes :");

        for (Double note : notes) {
            System.out.println(note);
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getFiliere() {
        return filiere;
    }

    public int getAnnee() {
        return annee;
    }

    public List<Double> getNotes() {
        return notes;
    }
}