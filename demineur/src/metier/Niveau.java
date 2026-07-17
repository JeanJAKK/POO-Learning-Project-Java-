/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author Aude
 */
public class Niveau {
    
    private final String libelle;
    private final int nombreLignes;
    private final int nombreColonnes;
    private final int nombreMines;
    
    
    public Niveau(){
        this("Débutant", 9, 9, 10);
    }
    public Niveau(String libelle, int nombreLignes, int nombresColonnes, int nombreMines){
        this.libelle = libelle;
        this.nombreLignes = nombreLignes;
        this.nombreColonnes = nombresColonnes;
        this.nombreMines = nombreMines;
    }
    
    public int getNombreCases(){
        return this.nombreColonnes * this.nombreLignes;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getNombreLignes() {
        return nombreLignes;
    }

    public int getNombreColonnes() {
        return nombreColonnes;
    }

    public int getNombreMines() {
        return nombreMines;
    }
}