/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo1;

/**
 *
 * @author jakk
 */
public class Poo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Créeer et présenter etudiants
        System.out.print("PRESENTATION ETUDIANTS\n");
        System.out.print("=".repeat(30));
        System.out.print("\n");
        Etudiant etudiant1 = new Etudiant("AMAH", "Kwatcha", 18);
        etudiant1.sePresenter();
        Etudiant etudiant2 = new Etudiant("ABALO", "Afi", 21);
        etudiant2.sePresenter();
        Etudiant etudiant3 = new Etudiant("AKAKPO", "Tcha-Esso", 21);
        etudiant3.sePresenter();
        Etudiant etudiant4 = new Etudiant("JAKK", "Jean", 18);
        etudiant4.sePresenter();
        etudiant1.setAge(22);
        etudiant1.sePresenter();
        
        // Créer et presenter enseignant
        System.out.print("\n");
        System.out.print("PRESENTATION ENSEIGNANTS\n");
        System.out.print("=".repeat(30));
        System.out.print("\n");
        Enseignant enseignant1 = new Enseignant("HAMA", "Tchakwa", "POO");
        enseignant1.sePresenter();
        Enseignant enseignant2 = new Enseignant("ALOBA", "Ida", "MERISE");
        enseignant2.sePresenter();
        Enseignant enseignant3 = new Enseignant("BALAO", "Esso", "Anglais");
        enseignant3.sePresenter();
    }
    
}
