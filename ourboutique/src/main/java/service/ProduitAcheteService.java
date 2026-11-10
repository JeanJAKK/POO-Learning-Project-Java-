/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entité.ProduitAchete;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class ProduitAcheteService {
    private final List<ProduitAchete> liste;
    private static ProduitAcheteService instance;
    
    private ProduitAcheteService(){
        liste = new ArrayList<>();
    }
    
    public static ProduitAcheteService getInstance(){
        if(instance == null){
            instance = new ProduitAcheteService();
        }
        return instance;
    }
    
    public void ajouter(ProduitAchete p){
        if(p != null){
            liste.add(p);
        }
    }
    
    public void modifier(ProduitAchete p){
        for(ProduitAchete _p : liste){
            if(_p.equals(p)){
                _p = new ProduitAchete(p);
            }
        }
    }
    
    public ProduitAchete trouver(ProduitAchete pa){
        for (ProduitAchete p : liste){
            if(p.equals(pa)){
                return p;
            }
        }
        return null;
    }
    
    public ProduitAchete trouver(Integer idProduit, Long idAchat){
        for (ProduitAchete p : liste){
//            if(p.getProduit().getId().){
                return p;
            }
        
        return null;
    }
    
    public void supprimer(ProduitAchete p){
        for (ProduitAchete _p : liste){
            if(_p.equals(p)){
                liste.remove(_p);
            }
        }
        
    }
    
    public int compter(){
        return liste.size();
    }
    
    public List<ProduitAchete> lister(){
        return this.liste;
    }
    
}
