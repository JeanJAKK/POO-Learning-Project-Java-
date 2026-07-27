/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import entite.Groupe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class GroupeUI extends JFrame{
    private Groupe groupe;
    private JTextField id;
    private JTextField nom;
    private JTextField description;
    private JButton boutonEnregistrer;
    private JTextArea output = new JTextArea("");
    private JButton ajouter;
    private JButton trouver;
    private JButton modifier;
    private JButton supprimer;
    private JButton lister;
    
    
    public GroupeUI() throws ObjetNonTrouveException{
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Dashboard groupe");
        this.setSize(800, 600); 
        this.setLocationRelativeTo(null);
        this.add(creerFormulaire(), BorderLayout.WEST);
        this.add(creerEcran());
        this.setVisible(true);
    }
    
    public GroupeUI(Groupe groupe) throws ObjetNonTrouveException{
        this();
        this.groupe = groupe;
    }
    
    public final JPanel creerFormulaire(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.ipadx = 10;
        gbc.ipady = 10;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nom obligatoire"), gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nom"), gbc);
        gbc.gridx = 1;
        nom =  new JTextField(15);
        panel.add(nom, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Description"), gbc);
        gbc.gridx = 1;
        description =  new JTextField(15);
        panel.add(description, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        boutonEnregistrer = new JButton("Enregistrer");
        panel.add(boutonEnregistrer, gbc);
        
        return panel;
    }
    
    public final JPanel creerEcran(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipadx = 5;
        gbc.ipady = 5;
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Actions sur groupe"), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        ajouter =  new JButton("Ajouter");
        inputPanel.add(ajouter ,gbc);
        
        gbc.gridx = 1;
        trouver = new JButton("Trouver");
        inputPanel.add(trouver ,gbc);
        
        gbc.gridx = 2;
        modifier = new JButton("Modifier");
        inputPanel.add(modifier, gbc);
        
        gbc.gridx = 3;
        supprimer = new JButton("Supprimer");
        inputPanel.add(supprimer, gbc);
        
        gbc.gridx = 4;
        lister = new JButton("Lister");
        inputPanel.add(lister, gbc);
        
        //Ecran de sortie
        output = new JTextArea(20, 20);
        output.setLineWrap(true);
        output.append("Les resulats s'afficheront ici...");
        JScrollPane sp = new JScrollPane(output);
        
        inputPanel.setBackground(Color.lightGray);
        panel.add(inputPanel, BorderLayout.SOUTH);
        panel.add(sp, BorderLayout.CENTER);
        panel.setVisible(true);
        
        return panel;
    }
    
    public void modifierGroupe()throws ObjetNonTrouveException{
        if(id.getText().trim().equals("") || nom.getText().trim().equals("")){
            throw new ObjetNonTrouveException("Id et Nom requis");
        }
        
        this.groupe.setNom(nom.getText().trim());
        this.groupe.setDescription(description.getText().trim());
    }
    
    public Groupe getGroupe(){
        return groupe;
    }
    
    public JButton getBoutonAjouter(){
        return ajouter;
    }
    
    public JButton getBoutonModifier(){
        return modifier;
    }
    
    public JButton getBoutonTrouver(){
        return trouver;
    }
    
    public JButton getBoutonSupprimer(){
        return supprimer;
    }
    
    public JButton getBoutonLister(){
        return lister;
    }        
            
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
    }
    
    public void viderFormulaire(){
        nom.setText("");
        description.setText("");
    }
    
    public void afficherSurEcran(String affichage){
        output.setText(affichage);
    }
}
