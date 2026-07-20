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
        emf = Persistence.createEntityManagerFactory("jpaPU");
     }
     
    public void ajouterUtilisateur(Utilisateur user){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try{
           transaction.begin();
           em.persist(user);
           transaction.commit();
       }catch (Exception ex){
            if(transaction.isActive()){
                transaction.rollback();
            } 
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
           if(transaction.isActive()){
               transaction.rollback();
           }
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
           Utilisateur modifUser = em.find(Utilisateur.class, user.getId());
           modifUser.setNom(user.getNom());
           modifUser.setPrenom(user.getPrenom());
           modifUser.setIdentifiant(user.getIdentifiant());
           modifUser.setMotDePasse(user.getMotDePasse());
           modifUser.setGroupe(user.getGroupe());
           transaction.commit();
       }catch(Exception ex){
           if(transaction.isActive()){
               transaction.rollback();
           }
       }finally{
           em.close();
           emf.close();
       }
   }
   
   public void bestModifierUtilisateur(Utilisateur user){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try {
           transaction.begin();
           em.merge(user);
           transaction.commit();
       } catch (Exception e) {
           if(transaction.isActive()){
               transaction.rollback();
           }
       } finally {
           em.close();
           emf.close();
       }
   }
   
   public void supprimerUtilisateur(Utilisateur user){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try {
           transaction.begin();
           em.remove(user.getId());
           transaction.commit();
       } catch (Exception e) {
           if(transaction.isActive()){
               transaction.rollback();
           }
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
           listeUser = em.createQuery("SELECT u FROM Utilisateur u").getResultList();
       } catch (Exception e) {
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
       
       return listeUser;
   }
}
