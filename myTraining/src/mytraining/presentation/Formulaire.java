/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mytraining.presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author jakk
 */
public class Formulaire extends JFrame{
    
    public Formulaire(String titre){
        JFrame jf = new JFrame(titre);
        JPanel jp = new JPanel(new GridLayout(5, 2, 5, 5));
        jp.setBackground(Color.LIGHT_GRAY);
        
        jp.add(new JLabel("Nom"));
        JTextField inputTxt1 = new JTextField("DEV", 20);
        jp.add(inputTxt1);
        
        jp.add(new JLabel("Prénom"));
        JTextField inputTxt2 = new JTextField("Jakk", 20);
        jp.add(inputTxt2);
        
        jp.add(new JLabel("Date de naissance"));
        JTextField inputTxt3 = new JTextField("03-06-09", 20);
        jp.add(inputTxt3);
        
        jp.add(new JLabel("Email"));
        JTextField inputTxt4 = new JTextField("jakkdev27@gmail.com", 20);
        jp.add(inputTxt4);
        
        jp.add(new JLabel("Sexe"));
        ButtonGroup btnGrp = new ButtonGroup();
        JRadioButton h = new JRadioButton("Homme", true);
        JRadioButton f = new JRadioButton("Femme");
        btnGrp.add(h);
        btnGrp.add(f);
        jp.add(h);
        jp.add(f);
        
        JButton submit = new JButton("Soumettre");
        
        submit.addActionListener((ae) -> {
            int confirm = JOptionPane.showConfirmDialog(jf, "Confimez vos informations!");
            if(confirm == 0){
                String inputedName = inputTxt1.getText();
                String inputedPrenom = inputTxt2.getText();
                String inputEmail = inputTxt3.getText();
                String inputedDate = inputTxt4.getText();
                String inputedSexe = h.addItemListener(l)? "Homme" : "Femme";
                
                JOptionPane.showMessageDialog(jf, "Opération effecuer avec succès");
            }else{
                JOptionPane.showMessageDialog(jf, "Quoi encore?");
            }
        });
        
        jf.add(jp);
        jf.add(submit);
        jf.setSize(800, 500);
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        
   }
}
