/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jakk
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            restaurer();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void sauvegarder() throws Exception{
        Personne personne = new Personne("RORONOA","Zoro",23);
        FileOutputStream fichier;
        fichier = new FileOutputStream("/home/jakk/Bureau/CoursPOO/output/personne.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fichier);
        objectOutputStream.writeObject(personne);
        objectOutputStream.flush();
    }
    
    public static void restaurer()throws Exception{
        FileInputStream fichier = new FileInputStream("/home/jakk/Bureau/CoursPOO/output/personne.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fichier);
        Personne personne = (Personne) objectInputStream.readObject();
        System.out.println(personne);
//        System.out.println("Nom : " + personne.getNom());
//        System.out.println("Prenom : " + personne.getPrenom());
//        System.out.println("Age : " + personne.getAge());


    }
}
