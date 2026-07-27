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
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class GroupeDao {
    public static EntityManagerFactory emf;
    
     static{
        emf = Persistence.createEntityManagerFactory("jpaPU");
     }
    
    
    public void ajouterGroupe(Groupe grp){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();
            em.persist(grp);
            transaction.commit();
        }catch (Exception ex){
             if(transaction.isActive()){
                 transaction.rollback();
             }
             throw ex;
        }finally{
            em.close();
        }
    }

    public Groupe trouverGroupe(int id){
        EntityManager em = emf.createEntityManager();
        Groupe findedGrp = new Groupe();

        try {
            findedGrp = em.find(Groupe.class, id);
        } catch (Exception ex) {
            throw ex;
        }finally{
            em.close();
        }
        return findedGrp;
    }

    public Groupe trouverGroupe(String nom) throws Exception{
        EntityManager em = emf.createEntityManager();
        Groupe findedGroupe = new Groupe();

        try{
             String jpql = "SELECT g FROM Groupe g WHERE g.nom=:nom";
             findedGroupe = (Groupe) em.createQuery(jpql).setParameter("nom", nom).getSingleResult();
        } catch(Exception ex){
            throw new ObjetNonTrouveException("Aucun groupe avec le nom " + nom + " trouvé");
        }finally{
            em.close();
        }
        return findedGroupe;           
    }

    public void modifierGroupe(Groupe grp){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();
            em.merge(grp);
            transaction.commit();
        }catch(Exception ex){
            if(transaction.isActive()){
               transaction.rollback();
            }
            throw ex;
        }finally{
            em.close();
        }
    }



    public void supprimerGroupe(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.remove(em.find(Groupe.class, id));
            transaction.commit();
        } catch (Exception ex) {
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw ex;
        }finally{
            em.close();
        }
    }

//    public void suprimerGroupe(String nom) throws Exception{
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//
//        try{
//            String jpql = "DELETE g FROM Groupe g WHERE g:nom=:nom";
//            transaction.begin();
//            em.createQuery(jpql).setParameter("nom", nom).executeUpdate();
//            transaction.commit();
//        }catch(Exception ex){
//            if(transaction.isActive()){
//                transaction.rollback();
//            }
//            throw new ObjetNonTrouveException(ex.getMessage());
//        }finally{
//            em.close();
//        }
//    }

    public List<Groupe> listerGroupe(){
        EntityManager em = emf.createEntityManager();
        List<Groupe> listeGrp = new ArrayList<>();

        try {
            listeGrp = em.createQuery("SELECT g FROM Groupe g").getResultList();
        } catch (Exception ex) {
            throw ex;
        }finally{
            em.close();
        }
        return listeGrp;
    }
}
