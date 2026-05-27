/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serialisation;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author jakk
 */
public class Personne implements Serializable{
    @Serial
    static final long serialVersionUID = -3387516993124229948L;
    private String nom;
    private String prenom;
    private int age;
   // private int id;
    
    
    public Personne(){
        
    }
    
    public Personne(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    
//    public int getId(){
//        return this.id;
//    }
//    
//    public void setId(int id){
//        this.id = id;
//    }
    
    @Override
    public String toString(){
        return this.nom + "\t" + this.prenom + "\t" + this.age;
    }
    
}
