/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo1;

/**
 *
 * @author jakk
 */
public class Enseignant {
    private String nom;
    private String prenom;
    private String UE;
    public Enseignant(String nom, String prenom, String UE){
        this.nom = nom;
        this.prenom = prenom;
        this.UE = UE;
    }
    public void sePresenter(){
        System.out.print("Je suis M ");
        System.out.print(this.nom + " " + this.prenom + " ,");
        System.out.print("chargé de l'UE " + this.UE +".\n");
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getUE(){
        return UE;
    }
    public void setUE(String UE){
        this.UE = UE;
    }
    
}
