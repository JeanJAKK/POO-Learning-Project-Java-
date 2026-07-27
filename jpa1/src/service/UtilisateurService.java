/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UtilisateurDao;
import entite.Utilisateur;
import java.util.List;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class UtilisateurService {
    private final UtilisateurDao dao;
    
    public UtilisateurService(){
        this.dao = new UtilisateurDao();
    }
    
    public void ajouter(Utilisateur user) throws ObjetNonTrouveException{
        if(user.getIdentifiant().trim().equals("") && user.getNom().trim().equals("")){
            throw new ObjetNonTrouveException("Nom et identifiant requis");
        }
        this.dao.ajouterUtilisateur(user);
    }
    
    public Utilisateur trouver(Utilisateur user) throws Exception{
        if(!user.getId().equals("")){
            return this.dao.trouverUtilisateur(user.getId());
        }
        
        if(!user.getIdentifiant().equals("")){
            return this.dao.trouverUtilisateur(user.getIdentifiant());
        }
        return null;
    }
    
    public void modifier(Utilisateur user) throws Exception{
        if(user.getId().equals("")){
            throw new ObjetNonTrouveException("Id requis");
        }
        this.dao.modifierUtilisateur(user);
    }
    
    public List<Utilisateur> lister() throws Exception{
        return this.dao.listerUtilisateur();
    }
    
    public void supprimer(Utilisateur user) throws Exception{
        if(!user.getId().equals("")){
            this.dao.supprimerUtilisateur(user.getId());
            return;
        }
        
        if(!user.getIdentifiant().equals("")){
            this.dao.supprimerUtilisateur(user.getIdentifiant());
            return;
        }
    }
    
}
