/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entité;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author jakk
 */
public class Produit {
    private long id;
    private String libelle;
    private double prixUnitaire;
    private Date datePeremption;
    private Categorie categorie;

    public Produit(long id, String libelle, double prixUnitaire, Date datePeremption, Categorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = datePeremption;
        this.categorie = categorie;
    }

    public Produit(Produit p) {
        this.id = p.id;
        this.libelle = p.libelle;
        this.prixUnitaire = p.prixUnitaire;
        this.datePeremption = p.datePeremption;
        this.categorie = p.categorie;
    }
    
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public String getLibelle(){
        return libelle;
    }
    
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    
    public double getPrixUnitaire(){
        return prixUnitaire;
    }
    
    public void setPrixUnitaire(double prix){
        this.prixUnitaire = prix;
    }
    
    public Date getDatePeremption(){
        return datePeremption;
    }
    
    public void setDatePeremption(Date date){
        this.datePeremption = date;
    }
    
    public boolean estPerime(){
        return true;
    }
    
    public boolean estPerime(Date dateReference){
        return true;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        
        final Produit produit = (Produit)obj;
        return this.id == produit.id;
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 39 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public String toString(){
        return "Détails sur l'achat\n id :" + id + "\nLibelle :" + libelle + "\nPrix unitaire:"
                + prixUnitaire + "\nDate de péremption:" + datePeremption + "\nCatégorie:" + categorie;
    }
}
