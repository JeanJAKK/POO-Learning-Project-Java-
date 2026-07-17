/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import metier.Case;
import metier.Partie;

/**
 *
 * @author Aude
 */
public class Plateau extends JFrame {

    private Partie partie;
    private JPanel champ = new JPanel();
    private List<CaseUI> caseUIs = new ArrayList<>();

    public Plateau(Partie p) {
        this.partie = p;
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.initialiserChamp();
        this.add(champ, BorderLayout.CENTER);
    }
    
    public void afficher(){
        for(CaseUI c : caseUIs){
            c.afficher();
        }
    }
    private void initialiserChamp() {
        int lignes = this.partie.getNiveau().getNombreLignes();
        int colonnes = this.partie.getNiveau().getNombreColonnes();
        champ.setLayout(new GridLayout(lignes, colonnes));

        for (Case c : this.partie.getCases()) {
            CaseUI caseUI = new CaseUI(c, this);
            this.caseUIs.add(caseUI);
            this.champ.add(caseUI);
        }
    }
    
}