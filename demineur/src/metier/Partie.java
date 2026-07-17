/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Aude
 */
public class Partie {
    private EtatJeuEnum etat = EtatJeuEnum.ATTENTE;
    private LocalDate heureDebut;
    private LocalDate heureFin;
    private boolean gagnee = false;
    
    private List<Case> cases = new ArrayList();
    private Minuteur minuteur;
    private CompteurMine compteurMine;
    private Niveau niveau;
    

    public Partie(Niveau niveau){
        this.niveau = niveau;
        int NombreCase = niveau.getNombreCases();
        for(int i = 0; i < NombreCase; i++){
            Case _case = new Case(this);
            this.cases.add(_case);
        }
    }
    
    public Case getcase(int ligne, int colonne) throws Exception{
        int nombreColonnes = this.niveau.getNombreColonnes();
        int position = ligne * nombreColonnes + colonne;
        
        if(position < 0 || position >=  this.niveau.getNombreCases()){
            throw new Exception("Coordonnées ivalides");
        }
        return this.cases.get(position);
    }
    
    public void demarrer(Case premiereCase){
        if(this.etat == EtatJeuEnum.ATTENTE){
            this.etat = EtatJeuEnum.ENCOURS;
            this.setMines(premiereCase);
        }
    }
    
    public void setMines(Case caseExceptee){
        int nombreMines = this.niveau.getNombreMines();
        int nombreCases = this.niveau.getNombreCases();
        int conteur = 0;
        Random random = new Random();
        while(conteur < nombreMines){
            int position = random.nextInt(0, cases.size());
            Case _case = this.cases.get(position);
            if(!_case.isMinee()){
                _case.setMine();
                conteur++;
            }
        }
    }
    
    public void toutDevoiler(){
        for(Case c : cases){
            c.devoiler();
        }
    }
    
    public void terminerAvecEchec(){
        this.etat = EtatJeuEnum.TERMINEE;
        this.toutDevoiler();
    }
    
    public LocalDate getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalDate heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalDate getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalDate heureFin) {
        this.heureFin = heureFin;
    }

    public boolean isGagnee() {
        return gagnee;
    }

    public void setGagnee(boolean gagnee) {
        this.gagnee = gagnee;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public Niveau getNiveau() {
        return niveau;
    }
    
}