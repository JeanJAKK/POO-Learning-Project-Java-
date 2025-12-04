/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion.fichiers.metier;

import gestion.fichiers.cli.Commande;
import gestion.fichiers.cli.ParseurCommande;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author jakk
 */
public abstract class Fichier {
    private LocalDateTime dateCreation;
    private String nom;
    private Repertoire repertoireParent;
    
    
    public Fichier(){
        this.dateCreation = LocalDateTime.now();
    }
    public Fichier(String nom){
        this();
        this.nom = nom;
    }
    public Fichier(String nom, Repertoire repertoireParent){
        this(nom);
        this.repertoireParent = repertoireParent;
        if(repertoireParent != null){
            this.repertoireParent.getFichier().add(this);
        }
    }
    public abstract int getTaille();
    public String getNomComplet(){
        if(repertoireParent == null){
            return this.nom;
        }
        return repertoireParent.getNomComplet() + "/" + this.nom;
    }
    
   public String getNom(){
       return this.nom;
   } 
}