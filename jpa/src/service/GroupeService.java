/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.GroupeDao;
import entite.Groupe;
import java.util.List;

/**
 *
 * @author jakk
 */
public class GroupeService {
    private final GroupeDao dao;
    
    public GroupeService(){
        this.dao = new GroupeDao();
    }
    
    public void ajouter(Groupe grp){
        this.dao.ajouterGroupe(grp);
    }
    
    public void modifier(Groupe grp) throws Exception{
        this.dao.modifierGroupe(grp);
    }
    
    public Groupe trouver(int id) throws Exception{
        return this.dao.trouverGroupe(id);
    }
    
    public List<Groupe> lister() throws Exception{
        return this.dao.listerGroupe();
    }
    
    public void supprimer(int id) throws Exception{
        this.dao.supprimerGroupe(id);
    }
    
}
