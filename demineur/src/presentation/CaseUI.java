/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import metier.Case;

/**
 *
 * @author jakk
 */
public class CaseUI extends JButton {

    private final Plateau plateau;
    private final Case caseMetier;

    public CaseUI(Case caseMetier, Plateau p) {
        EcouteurCaseUI ecouteur = new EcouteurCaseUI();
        this.plateau = p;
        this.caseMetier = caseMetier;
        this.addMouseListener(ecouteur);
    }

    public Case getCaseMetier() {
        return this.caseMetier;
    }

    public Plateau getPlateau() {
        return this.plateau;
    }

    public void afficher() {
        if (this.caseMetier.isMarquee()) {
            afficherDrapeau();
        } else {
            this.setIcon(null);
        }
        if (this.caseMetier.isDevoilee()) {
            if (this.caseMetier.isMinee()) {
                afficherMine();
            } else {
                afficherContenu();
            }
        }
    }

    private void afficherContenu() {
        this.setBackground(Color.WHITE);
        String texte = this.caseMetier.getContenu();
        this.setText(texte);
    }

    private void afficherDrapeau() {
        URL url = getClass().getResource("/images/drapeau.jpeg");
        ImageIcon icone = new ImageIcon(url);
        this.setIcon(icone);
    }

    private void afficherMine() {
        URL url = getClass().getResource("/images/mine.jpeg");
        ImageIcon icone = new ImageIcon(url);
        this.setIcon(icone);
    }
}