/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entite.Groupe;
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
public class GroupeDao {
    public static EntityManagerFactory emf;
    
     static{
        emf = Persistence.createEntityManagerFactory("monUnite");
     }
    
    
   public void ajouterGroupe(Groupe grp){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try{
           transaction.begin();
           em.persist(grp);
           transaction.commit();
       }catch (Exception ex){
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
   }
   
   public Groupe trouverGroupe(int id){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       Groupe findedGrp = new Groupe();
       
       try {
           transaction.begin();
           findedGrp = em.find(Groupe.class, id);
       } catch (Exception e) {
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
       return findedGrp;
   }
   
   public void modifierGroupe(Groupe grp){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       
       try{
           transaction.begin();
           em.merge(grp);
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
   
   public List<Groupe> listerGroupe(){
       EntityManager em = emf.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       List<Groupe> listeGrp = new ArrayList<>();
       
       try {
           transaction.begin();
           listeGrp = em.find(Groupe.class, id);
       } catch (Exception e) {
           transaction.rollback();
       }finally{
           em.close();
           emf.close();
       }
       
       return listeGrp;
   }
}
