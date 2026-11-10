/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entité;

import java.util.Objects;

/**
 *
 * @author jakk
 */
public class Categorie {
    private Integer id;
    private String libelle;
    private String description;

    public Categorie() {
    }

    public Categorie(Integer id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }
    
    public Categorie(Categorie cat) {
        this.id = cat.id;
        this.libelle = cat.libelle;
        this.description = cat.description;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getLibelle(){
        return libelle;
    }
    
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description =  description;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        
        final Categorie cat = (Categorie)obj;
        return Objects.equals(this.id, cat.id);
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public String toString(){
        return "Détails sur categorie\n id :" + id + "\nLbelle:" + libelle + "Description:" +
                description;
    }
}
