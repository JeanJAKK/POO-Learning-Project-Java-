/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.UtilisateurDao;
import entite.Utilisateur;
import java.util.List;

/**
 *
 * @author jakk
 */
public class UtilisateurService {
    private final UtilisateurDao dao;
    
    public UtilisateurService(){
        this.dao = new UtilisateurDao();
    }
    
    public void ajouter(Utilisateur user){
        this.dao.ajouterUtilisateur(user);
    }
    
    public Utilisateur trouver(int id) throws Exception{
         return this.dao.trouverUtilisateur(id);
    }
    
    public void bestModifier(Utilisateur user) throws Exception{
        this.dao.bestModifierUtilisateur(user);
    }
    
    public void modifier(Utilisateur user) throws Exception{
        this.dao.modifierUtilisateur(user);
    }
    
    public List<Utilisateur> lister() throws Exception{
        return this.dao.listerUtilisateur();
    }
    
    public void supprimer(Utilisateur user) throws Exception{
        this.dao.supprimerUtilisateur(user);
    }
}
