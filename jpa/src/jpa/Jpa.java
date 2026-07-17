/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa;

import entite.Groupe;
import entite.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 *
 * @author jakk
 */
public class Jpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();

        Groupe g1 = new Groupe("Groupe 1", "Premier groupe");

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(g1);
        } catch (Exception e) {
            transaction.rollback();
        }
    }
    
     private static void test2() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager em = emf.createEntityManager();

        Groupe g1 = new Groupe("Groupe 2", "Deuxième groupe");
        Utilisateur utilisateur = new Utilisateur("RORONOA", "Zoro", "zroronoa", "123456789", g1);

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(utilisateur);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }

}