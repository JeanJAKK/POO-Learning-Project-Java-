/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpa;

import entite.Groupe;
import entite.Utilisateur;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import presentation.controleur.GroupeControleur;
import presentation.controleur.UtilisateurControleur;
import presentation.vue.UtilisateurDashboard;
import presentation.vue.UtilisateurUI;
import service.GroupeService;
import service.UtilisateurService;

/**
 *
 * @author jakk
 */
public class Jpa {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        new UtilisateurUI();
           }
//        UtilisateurControleur userCtrl = new UtilisateurControleur();
//        GroupeControleur grpCtrl = new GroupeControleur();
//        JFrame frame = new JFrame();
//        JButton userBtn;
//        JButton grpBtn;
//        JPanel panelOp;
//        String aide = "";
//
//        JPanel panel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
//        gbc.insets = new Insets(5, 5, 5, 5);
//        gbc.fill = GridBagConstraints.BOTH;
//        gbc.ipadx = 10;
//        gbc.ipady = 10;
//
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        panel.add(new JLabel(aide), gbc);
//
//        gbc.gridy = 1;
//        userBtn = new JButton("Utilisateur");
//        panel.add(userBtn, gbc);
//
//        gbc.gridx = 1;
//        grpBtn = new JButton("Groupe");
//        panel.add(grpBtn, gbc);
//
//        gbc.gridy = 2;
//        gbc.gridx = 0;
//        panelOp = Jpa.panelOperation();
//        panel.add(panelOp, gbc);
////
////        userBtn.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent ae) {
////                panelOp.setVisible(true);
////                isUser = true ;
////            }
////        });
////
////        grpBtn.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent ae) {
////                if (!isUser) {
////                    panelOp.setVisible(true);
////                }
////
////            }
////        });
//
//        frame.add(panel);
//        frame.setVisible(true);
//
////        Groupe g1 = new Groupe();
////        Utilisateur grp = new Utilisateur("MONKEY", "Luffy", "MKYDLUFF45", "23324", g1);
////        UtilisateurService service = new UtilisateurService();
////        try {
////            List<Utilisateur> listeGrp = service.lister();
////            for (Utilisateur groupe : listeGrp) {
////                System.out.println(groupe.toString());
////            }
////        } catch (Exception ex) {
////            Logger.getLogger(Jpa.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        Groupe g1 = new Groupe(1, "Groupe 1", "Premier groupe modifié 2");
////        Utilisateur u1 = new Utilisateur(2,"MONKEY", "Luffy", "MKYDLUFF45", "23324modifié", g1);
////        UtilisateurService service = new UtilisateurService();
////            service.modifier(u1);
//        Groupe g = new Groupe("Groupe 1", "Premier groupeee modifié 2");
//        GroupeService gs = new GroupeService();
//        Utilisateur user  = new Utilisateur();
//        UtilisateurControleur us = new UtilisateurControleur();
//        GroupeControleur gc = new GroupeControleur();
//        us.trouver();
//    }
//
//    public static JPanel panelOperation() {
//        JPanel p = new JPanel(new GridBagLayout());
//        GridBagConstraints contrainte = new GridBagConstraints();
//        JButton btnAdd;
//        JButton btnUpdate;
//        JButton btnDelete;
//        JButton btnFind;
//        JButton btnList;
//
//        contrainte.fill = GridBagConstraints.BOTH;
//        contrainte.gridwidth = 1;
//        contrainte.gridheight = 1;
//        contrainte.ipadx = 10;
//        contrainte.ipady = 10;
//        contrainte.insets = new Insets(5, 5, 5, 5);
//
//        contrainte.gridx = 0;
//        contrainte.gridy = 0;
//        btnAdd = new JButton("Ajouter");
//        p.add(btnAdd);
//
//        contrainte.gridy = 1;
//        btnFind = new JButton("Trouver");
//        p.add(btnFind);
//
//        contrainte.gridy = 2;
//        btnUpdate = new JButton("Modifier");
//        p.add(btnUpdate);
//
//        contrainte.gridy = 3;
//        btnDelete = new JButton("Supprimer");
//        p.add(btnDelete);
//
//        contrainte.gridy = 4;
//        btnList = new JButton("Lister");
//        p.add(btnList);
//
//        return p;
//    }

}
