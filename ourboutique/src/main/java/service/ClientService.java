/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entité.Client;
import entité.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class ClientService {
    private final List<Client> liste;
    private static ClientService instance;
    
    private ClientService(){
        liste = new ArrayList<>();
    }
    
    public static ClientService getInstance(){
        if(instance == null){
            instance = new ClientService();
        }
        return instance;
    }

    public void ajouter(Client p){
        if(p != null){
            liste.add(p);
        }
    }
    
    public void modifier(Client p){
        for(Client _p : liste){
            if(_p.equals(p)){
                _p = new Client(p);
            }
        }
    }
    
    public Client trouver(Long id){
        for (Client p : liste){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public void supprimer(Long id){
        for (Client p : liste){
            if(p.getId() == id){
                liste.remove(p);
            }
        }
        
    }
    
    public void supprimer(Client p){
        for (Client _p : liste){
            if(_p.equals(p)){
                liste.remove(_p);
            }
        }
        
    }
    
    public int compter(){
        return liste.size();
    }
    
    public List<Client> lister(){
        return this.liste;
    }
    
}