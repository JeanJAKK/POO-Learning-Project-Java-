/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class UtilisateurDao {
    public static EntityManagerFactory emf;
    
     static{
        emf = Persistence.createEntityManagerFactory("monUnite");
     }
     
    public void ajouterUtilisateur(Utilisateur user){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try{
           transaction.begin();
           em.persist(user);
           transaction.commit();
       }catch (Exception ex){
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
   }
   
   public Utilisateur trouverUtilisateur(int id){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       Utilisateur findedUser = new Utilisateur();
       
       try {
           transaction.begin();
           findedUser = em.find(Utilisateur.class, id);
       } catch (Exception e) {
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
       return findedUser;
   }
   
   public void modifierUtilisateur(Utilisateur user){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try{
           transaction.begin();
           em.merge(user);
           transaction.commit();
       }catch(Exception ex){
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
   }
   
   public void supprimerUtilisateur(int id){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try {
           transaction.begin();
           em.remove(id);
           transaction.commit();
       } catch (Exception e) {
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
   }
   
   public List<Utilisateur> listerUtilisateur(){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       List<Utilisateur> listeUser = new ArrayList<>();
       
       try {
           transaction.begin();
           listeUser = em.createQuery("SELECT g FROM utilisateurs g").getResultList();
       } catch (Exception e) {
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
       
       return listeUser;
   }
}
