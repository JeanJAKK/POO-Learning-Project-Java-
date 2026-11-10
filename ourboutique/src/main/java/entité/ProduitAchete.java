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
public class ProduitAchete {
    private double remise;
    private Achat achat;
    private Produit produit;
    
    public ProduitAchete(double remise, Achat achat, Produit produit) {
        this.remise = remise;
        this.achat = achat;
        this.produit = produit;
    }
    
    public ProduitAchete(ProduitAchete pa) {
        this.remise = pa.remise;
        this.achat = pa.achat;
        this.produit = pa.produit;
    }
    
    public double getRemise(){
        return remise;
    }
    
    public void setRemise(double remise){
        this.remise = remise;
    }
    
    public Produit getProduit(){
        return produit;
    }
    
    public void setProduit(Produit p){
        this.produit = p;
    }
    
    public Achat getAchat(){
        return achat;
    }
    
    public void setAchat(Achat _achat){
        this.achat = _achat;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        
        final ProduitAchete produitAchete = (ProduitAchete)obj;
        return this.achat.getId() == produitAchete.achat.getId() && 
                this.produit.getId() == produitAchete.produit.getId();
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.produit.getId());
        hash = 79 * hash + Objects.hashCode(this.achat.getId());
        return hash;
    }
    
    @Override
    public String toString(){
        return "Détails sur produit acheté\n achat :" + achat + "\nRemise :" + remise
                + "\nProduits:" + produit;
    }   

}
