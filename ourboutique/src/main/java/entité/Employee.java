/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entité;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author jakk
 */
public class Employee extends Personne{
    public Date dateNaissance;

    public Employee() {
    }

    public Employee(Date dateNaissance, long id, String nom, String prenom) {
        super(id, nom, prenom);
        this.dateNaissance = dateNaissance;
    }
    
    public Employee(Employee e) {
        super(e.id, e.nom, e.prenom);
        this.dateNaissance = e.dateNaissance;
    }
    
    public Date getDateNaissance(){
        return dateNaissance;
    }
    
    public void setDateNaissance(Date date){
        this.dateNaissance = date;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        
        final Employee employe = (Employee)obj;
        return this.id == employe.id;
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public String toString(){
        return "Détails sur l'achat\n id :" + id + "\nNom :" + nom + "\nPrenom:"
                + prenom + "\nDate de naissance:" + dateNaissance;
    }
}
