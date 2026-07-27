/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jakk
 */

@Entity
@Table(name="utilisateurs")
public class Utilisateur implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nom", length = 60, nullable = false)
    private String nom;
    
    @Column(name = "prenom", length = 60, nullable = true)
    private String prenom;
    
    @Column(name = "identifiant", length = 60, nullable = false, unique = true)
    private String identifiant;
    
    @Column(name = "mot_de_passe", length = 60, nullable = true)
    private String motDePasse;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_groupe")
    private Groupe groupe;

    public Utilisateur(){
        
    }
    public Utilisateur(String nom, String prenom, String identifiant, String motDePasse, Groupe groupe) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.groupe = groupe;
    }
    
    
     public Utilisateur(Integer id, String nom, String prenom, String identifiant, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        
    }
     
    public Utilisateur(Integer id, String nom, String prenom, String identifiant, String motDePasse, Groupe groupe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.groupe = groupe;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Utilisateur{\n" + "id=" + id + ",\n nom=" + nom + ",\n prenom="
             + prenom + ",\n identifiant=" + identifiant + ",\n motDePasse=" + motDePasse + "\n}";
        
    }
   
    public Integer getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
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

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    public void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }
    
    public Groupe getGroupe(){
        return groupe;
    }
}