/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import java.io.Serializable;

/**
 *
 * @author jakk
 */

@Entity
@Table(name = "groupes")
public class Groupe implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name ="nom", nullable = false, unique = true)
    private String nom;
    
    @Column(name ="description", nullable = false)
    private String description;

    
    
    public Groupe(){
        
    }

    public Groupe(String nom, String description){
        this.nom = nom;
        this.description = description;
    }
    
    public Groupe(int id, String nom, String description){
        this.id = id;
        this.nom = nom;
        this.description = description;
    }
    
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Groupe other = (Groupe) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Groupe{\n" + "id=" + id + ",\n nom=" + nom + ",\n description=" + description + "\n}";
    }
    
    
}