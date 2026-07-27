/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa1;

import entite.Groupe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import presentation.controleur.GroupeControleur;
import presentation.controleur.UtilisateurControleur;
import service.GroupeService;

/**
 *
 * @author jakk
 */
public class Jpa1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UtilisateurControleur uc = new UtilisateurControleur();
        uc.ajouter();
       
        
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       Groupe g1 = new Groupe("Groupe 1", "Premier groupe");
       
       try{
           transaction.begin();
           em.persist(g1);
           transaction.commit();
       }catch (Exception ex){
           System.out.println(ex.getMessage());
           transaction.rollback();
       }*/
    }
    
}
