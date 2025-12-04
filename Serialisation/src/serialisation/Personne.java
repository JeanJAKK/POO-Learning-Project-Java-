/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialisation;

import java.io.Serializable;

/**
 *
 * @author jakk
 */
public class Personne implements Serializable{
    private String nom;
    private String prenom;
    private int age;
    
    
    public Personne(){
        
    }
    
    public Personne(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    @Override
    public String toString(){
        return this.nom + "\t" + this.prenom + "\t" + this.age;
    }
    
}
