/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jakk
 */
public class EcouteurBoutonAjouter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
        //System.out.println("Bouton 'Ajouter' sélectionné");
    }
    
}
