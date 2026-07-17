/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mytraining.entite;

import java.util.Date;

/**
 *
 * @author jakk
 */
public class Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private Date date_de_naissane;
    private String sexe;
    
    public Utilisateur(){
        
    }
    
    public Utilisateur(String nom, String prenom, String email, Date date, String sexe){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_de_naissane = date;
        this.sexe = sexe;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setSexe(String sexe){
        this.sexe = sexe;
    }
    
    public String getSexe(){
        return sexe;
    }
    
    public void setDate(Date date){
        this.date_de_naissane = date;
    }
    
    public Date getDate(){
        return date_de_naissane;
    }
}
