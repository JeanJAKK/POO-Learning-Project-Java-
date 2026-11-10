/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entité.Categorie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class CategorieService {
    private final List<Categorie> liste;
    private static CategorieService instance;
    
    private CategorieService(){
        liste = new ArrayList<>();
    }
    
    public static CategorieService getInstance(){
        if(instance == null){
            instance = new CategorieService();
        }
        return instance;
    }

    public void ajouter(Categorie p){
        if(p != null){
            liste.add(p);
        }
    }
    
    public void modifier(Categorie p){
        for(Categorie _p : liste){
            if(_p.equals(p)){
                _p = new Categorie(p);
            }
        }
    }
    
    public Categorie trouver(Integer id){
        for (Categorie p : liste){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public void supprimer(Integer id){
        for (Categorie p : liste){
            if(p.getId() == id){
                liste.remove(p);
            }
        }
        
    }
    
    public void supprimer(Categorie p){
        for (Categorie _p : liste){
            if(_p.equals(p)){
                liste.remove(_p);
            }
        }
        
    }
    
    public int compter(){
        return liste.size();
    }
    
    public List<Categorie> lister(){
        return this.liste;
    }
}