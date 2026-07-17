/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author jakk
 */
public class Utilisateur {
    private int id;
    private String identifiant;
    private String motDePasse;
    
    public Utilisateur(){
        
    }
    
    public Utilisateur(String ident, String mdp){
        this.identifiant = ident;
        this.motDePasse = mdp;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", identifiant=" + identifiant + '}';
    }
    
    
}