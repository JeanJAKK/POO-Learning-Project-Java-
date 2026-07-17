/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package swingexo1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author jakk
 */
public class SwingExo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        creerFormulaire();
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
    
    public static void creerFormulaire(){
        JFrame frame = new JFrame("Formulaire d'inscription à l'EPL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        frame.setLayout(new BorderLayout(10, 10));
        
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        
        panel.add(new JLabel("Nom:"));
        JTextField champnom = new JTextField();
        panel.add(champnom);
        
        panel.add(new JLabel("Email:"));
        JTextField champEmail= new JTextField();
        panel.add(champEmail);
        
        
        panel.add(new JLabel("Mot de passe:"));
        JTextField champPassword = new JTextField();
        panel.add(champPassword);
        
        
        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton boutonValider = new JButton("S'inscrire");
        panelBoutons.add(boutonValider);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panelBoutons, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    
}