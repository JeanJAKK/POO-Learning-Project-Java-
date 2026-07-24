/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.GroupeDao;
import entite.Groupe;
import java.util.List;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class GroupeService {
    private final GroupeDao dao;
    
    public GroupeService(){
        this.dao = new GroupeDao();
    }
    
    public void ajouter(Groupe grp) throws Exception{
        if(grp.getNom().trim().equals("")){
            throw new ObjetNonTrouveException("Nom requis");
        }
        this.dao.ajouterGroupe(grp);
    }
    
    public void modifier(Groupe grp) throws Exception{
        this.dao.modifierGroupe(grp);
    }
    
    public Groupe trouver(Groupe grp) throws Exception{
        return this.dao.trouverGroupe(grp.getId());
    }
    
    public List<Groupe> lister() throws Exception{
        return this.dao.listerGroupe();
    }
    
    public void supprimer(Groupe grp) throws Exception{
            this.dao.supprimerGroupe(grp.getId());
    }
    
}
