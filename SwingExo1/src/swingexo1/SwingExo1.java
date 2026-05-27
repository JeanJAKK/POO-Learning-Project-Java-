/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package swingexo1;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jakk
 */
public class SwingExo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        creerJFrame();
    }
    
    
    public static void creerJFrame() {
        JFrame fenetre = new JFrame();
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetre.setSize(400, 300);
        
        JPanel panelNord = new JPanel();
        panelNord.setBackground(Color.BLUE);
        JLabel labelNord = new JLabel("Username: connecté");
        panelNord.add(labelNord);
        
        JPanel panelOuest = new JPanel();
        panelOuest.setLayout(new BoxLayout(panelOuest, BoxLayout.Y_AXIS));
        panelOuest.setBackground(Color.LIGHT_GRAY);
        String[] list = {"Menu", "Page 1", "Page 2", "Page 4", "Page 5    "};
        
        for (String p : list){
            panelOuest.add(new JLabel(p));
        }
        
        
        JPanel panelSud = new JPanel();
        panelSud.setBackground(Color.GRAY);
        JLabel labelSud = new JLabel("@copyrigth...");
        panelSud.add(labelSud);
        
        
        JPanel panelEst = new JPanel();
        panelEst.setBackground(Color.CYAN);
        JLabel labelEst = new JLabel("Titre de page 1");
        panelEst.add(labelEst);
        
        
        BorderLayout borderLayout = new BorderLayout();
        fenetre.setLayout(borderLayout);        

        fenetre.add(panelNord, BorderLayout.NORTH);
        fenetre.add(panelSud, BorderLayout.SOUTH);
        fenetre.add(panelOuest, BorderLayout.WEST);
        fenetre.add(panelEst, BorderLayout.CENTER);


        fenetre.setVisible(true);
    }
    
    
}