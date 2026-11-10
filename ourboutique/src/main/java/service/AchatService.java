/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entité.Achat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class AchatService {
    private final List<Achat> liste;
    private static AchatService instance;
    
    private AchatService(){
        liste = new ArrayList<>();
    }
    
    public static AchatService getInstance(){
        if(instance == null){
            instance = new AchatService();
        }
        return instance;
    }

    public void ajouter(Achat p){
        if(p != null){
            liste.add(p);
        }
    }
    
    public void modifier(Achat p){
        for(Achat _p : liste){
            if(_p.equals(p)){
                _p = new Achat(p);
            }
        }
    }
    
    public Achat trouver(Long id){
        for (Achat p : liste){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public void supprimer(Long id){
        for (Achat p : liste){
            if(p.getId() == id){
                liste.remove(p);
            }
        }
        
    }
    
    public void supprimer(Achat p){
        for (Achat _p : liste){
            if(_p.equals(p)){
                liste.remove(_p);
            }
        }
        
    }
    
    public int compter(){
        return liste.size();
    }
    
    public List<Achat> lister(){
        return this.liste;
    }
    
}