/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entité.Produit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class ProduitService {
    private final List<Produit> liste;
    private static ProduitService instance;
    
    private ProduitService(){
        liste = new ArrayList<>();
    }
    
    public static ProduitService getInstance(){
        if(instance == null){
            instance = new ProduitService();
        }
        return instance;
    }
    
    public void ajouter(Produit p){
        if(p != null){
            liste.add(p);
        }
    }
    
    public void modifier(Produit p){
        for(Produit _p : liste){
            if(_p.equals(p)){
                _p = new Produit(p);
            }
        }
    }
    
    public Produit trouver(Long id){
        for (Produit p : liste){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public void supprimer(Long id){
        for (Produit p : liste){
            if(p.getId() == id){
                liste.remove(p);
            }
        }
        
    }
    
    public void supprimer(Produit p){
        for (Produit _p : liste){
            if(_p.equals(p)){
                liste.remove(_p);
            }
        }
        
    }
    
    public int compter(){
        return liste.size();
    }
    
    public List<Produit> lister(){
        return this.liste;
    }
    
    public List<Produit> listerPerimer(){
        for(Produit p : liste){
            if(p.estPerime()){
                System.out.println(p);
            }
        }
       return null;
    }
}