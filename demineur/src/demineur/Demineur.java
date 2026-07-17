/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package demineur;

import metier.Niveau;
import metier.Partie;
import presentation.Plateau;

/**
 *
 * @author jakk
 */
public class Demineur {

    public static void main(String[] args) {
        
        
        Niveau niveau = new Niveau();
        Partie partie = new Partie(niveau);
        Plateau plateau = new Plateau(partie);
        plateau.setVisible(true);
    }
}