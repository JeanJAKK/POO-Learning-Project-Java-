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
import util.ObjetNonTrouveException;

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
            System.out.println(ex.getMessage());
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
       } catch (Exception ex) {
           if(transaction.isActive()){
               transaction.rollback();
           }
           System.out.println(ex.getMessage());
       }finally{
           em.close();
           emf.close();
       }
       return findedUser;
    }
   
    public Utilisateur trouverUtilisateur(String identifiant) throws ObjetNonTrouveException{
       EntityManager em = emf.createEntityManager();
       Utilisateur findedUser = new Utilisateur();
       
       try {
           String jpql = "SELECT g FROM Utilisateur g WHERE g.identifiant=:identifiant";
           findedUser = (Utilisateur) em.createQuery(jpql).setParameter("identifiant", identifiant).getSingleResult();
       } catch (Exception e) {
           throw new ObjetNonTrouveException("Aucun utilisateur avec l'identifiant " + identifiant + " trouvé");
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
           if(transaction.isActive()){
               transaction.rollback();
           }
           System.out.println(ex.getMessage());
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
           em.remove(em.find(Utilisateur.class, id));
           transaction.commit();
       } catch (Exception ex) {
           if(transaction.isActive()){
               transaction.rollback();
           }
           System.out.println(ex.getMessage());
       }finally{
           em.close();
           emf.close();
       }
    }
   
    public void supprimerUtilisateur(String identifiant) throws ObjetNonTrouveException{
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try {
           String jpql = "DELETE FROM Utilisateur u WHERE u.identifiant=:identifiant";
           transaction.begin();
           em.createQuery(jpql).setParameter("identifiant", identifiant).executeUpdate();
           transaction.commit();
       } catch (Exception e) {
           throw new ObjetNonTrouveException("Aucun utilisateur avec l'identifiant " + identifiant + " trouvé");
       }
    }
   
    public List<Utilisateur> listerUtilisateur(){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       List<Utilisateur> listeUser = new ArrayList<>();
       
       try {
           transaction.begin();
           listeUser = em.createQuery("SELECT u FROM Utilisateur u").getResultList();
       } catch (Exception ex) {
           if(transaction.isActive()){
               transaction.rollback();
           }
           System.out.println(ex.getMessage());
       }finally{
           em.close();
           emf.close();
       }
       
       return listeUser;
    }
}
