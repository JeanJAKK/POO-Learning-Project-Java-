/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class Case {
    
    private Boolean minee = false;
    private final Partie partie;
    private EtatCaseEnum etat = EtatCaseEnum.INITIAL;
    
    public Case(Partie p){
        this.partie = p;
    }
    
    public void marquer(){
        switch (etat) {
            case EtatCaseEnum.INITIAL:
                this.etat = EtatCaseEnum.MARQUE;
                break;
            case EtatCaseEnum.MARQUE:
                this.etat = EtatCaseEnum.INITIAL;
                break;
        }
    }
    public void devoiler(){
        this.partie.demarrer(this);
        if(this.etat == EtatCaseEnum.INITIAL){
            this.etat = EtatCaseEnum.DEVOILE;
            if(this.minee){
                this.partie.terminerAvecEchec();
                return;
            }
            
            this.devoileVoisines();
            
        }
    }
    
    public boolean isDevoilee(){
        return this.etat == EtatCaseEnum.DEVOILE;
    }
    public boolean isMarquee(){
        return this.etat == EtatCaseEnum.MARQUE;
    }
    
    public String getContenu(){
        List<Case> voisines = this.getVoisines();
        int nombreMine = this.getNombreMines(voisines);
        
        return nombreMine == 0 ? "" : String.valueOf(nombreMine);
    }
    
    private void devoileVoisines(){
        List<Case> voisines = this.getVoisines();
        int nombreMine = this.getNombreMines(voisines);
        
        if(nombreMine == 0){
            for (Case voisine : voisines) {
                voisine.devoiler();
            }
        }
    }
    
    private int getNombreMines(List<Case> cases){
        int nombreMines=0;
        
        for(Case _case : cases){
            if(_case.isMinee()){
                nombreMines++;
            }
        }
        return nombreMines;
    }
    
    private List<Case> getVoisines(){
        List<Case> voisines = new ArrayList();
        int ligne = this.getLigne();
        int colonne = this.getColonne();
        
        this.ajouterVoisines(voisines, ligne-1, colonne-1);
        this.ajouterVoisines(voisines, ligne-1, colonne);
        this.ajouterVoisines(voisines, ligne-1, colonne+1);
        
        this.ajouterVoisines(voisines, ligne, colonne-1);
       // this.ajouterVoisines(voisines, ligne, colonne);
        this.ajouterVoisines(voisines, ligne, colonne+1);
        
        this.ajouterVoisines(voisines, ligne+1, colonne-1);
        this.ajouterVoisines(voisines, ligne+1, colonne);
        this.ajouterVoisines(voisines, ligne+1, colonne+1);
        
        return voisines;
    }
    
    private void ajouterVoisines(List<Case> voisines, int x, int y){
        try {
            voisines.add(this.partie.getcase(x, y));
        } catch (Exception ex) {
            
        }
    }
    
    private int getLigne(){
        int nombreColonnes = this.partie.getNiveau().getNombreColonnes();
        int position = this.partie.getCases().indexOf(this);
        
        return position / nombreColonnes;
    }
    
    private int getColonne(){
        
        int nombreColonnes = this.partie.getNiveau().getNombreColonnes();
        int position = this.partie.getCases().indexOf(this);
        
        return position % nombreColonnes;
    }

    public Partie getPartie() {
        return partie;
    }
    
    public void setMine(){
        this.minee = true;
    }
    public boolean isMinee(){
        return this.minee;
    }

    public EtatCaseEnum getEtat() {
        return etat;
    }
    
}