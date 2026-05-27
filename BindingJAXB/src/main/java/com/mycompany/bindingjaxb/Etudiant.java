/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bindingjaxb;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 *
 * @author jakk
 */
@XmlRootElement(name = "etudiant")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nom", "prenom", "filiere", "annee", "notes"})
public class Etudiant {

    @XmlAttribute
    private int id;

    @XmlElement(name = "nom", required = true)
    private String nom;

    @XmlElement(name = "prenom")
    private String prenom;

    @XmlElement(name = "filiere")
    private String filiere;

    @XmlElement(name = "annee")
    private int annee;

    @XmlElementWrapper(name = "notes")
    @XmlElement(name = "note")
    private List<Double> notes;

    @XmlTransient
    private String motDePasse; // exclu du XML

    public Etudiant() {}

    public Etudiant(int id, String nom, String prenom,
                   String filiere, int annee, List<Double> notes) {
        this.id = id; this.nom = nom; this.prenom = prenom;
        this.filiere = filiere; this.annee = annee; this.notes = notes;
    }

    public double getMoyenne() {
        return notes.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public String getNom()     { return nom; }
    public String getPrenom()  { return prenom; }
    public String getFiliere() { return filiere; }
    public int    getAnnee()   { return annee; }
    public List<Double> getNotes() { return notes; }
}
