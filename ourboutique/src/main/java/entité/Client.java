/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entité;

import java.util.Objects;

/**
 *
 * @author jakk
 */
public class Client extends Personne{

    public Client(Long id, String nom, String prenom) {
        super(id, nom, prenom);
    }
    
    public Client(Client c) {
        super(c.id, c.nom, c.prenom);
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null || this.getClass()!= obj.getClass()){
            return false;
        }
        
        final Client client = (Client)obj;
        return this.id == client.id;
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 49 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public String toString(){
        return "Détails sur le client\n id :" + id + "\nNom :" + nom + "\nPrenom:"
                + prenom;
    }
}
