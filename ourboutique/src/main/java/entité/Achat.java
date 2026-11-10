/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entité;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jakk
 */
public class Achat {
   private long id;
   private Date dateAchat;
   private double remise;
   private List<ProduitAchete> produitacheter;
   private Employee employee;
   private Client client;

    public Achat() {
    }

    public Achat(long id, Date dateAchat, double remise) {
        this.id = id;
        this.dateAchat = dateAchat;
        this.remise = remise;
    }
    
    public Achat(Achat a) {
        this.id = a.id;
        this.dateAchat = a.dateAchat;
        this.remise = a.remise;
    }
    
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public Date getDateAchat(){
        return dateAchat;
    }
    
    public void setDateAchat(Date date){
        this.dateAchat = date;
    }
    
    public double getRemise(){
        return remise;
    }
    
    public void setRemise(double remise){
        this.remise = remise;
    }
            
    public double getRemiseTotale(){
        return remise;
    }
    
    public List<ProduitAchete> getProduitAchete(){
        return produitacheter;
    }
    
    public void setProduitAchete(List<ProduitAchete> p){
        this.produitacheter = p;
    }

    public double getTotalAPayer(){
        return 1.00;
    }
    
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        
        final Achat achat = (Achat)obj;
        return this.id == achat.id;
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public String toString(){
        return "Détails sur l'achat\n id :" + id + "\nDate :" + dateAchat + "\nRemise:"
                + remise + "\nEmpploye:" + employee + "\nClient:" + client;
    }
}
