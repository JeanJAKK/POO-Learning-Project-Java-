/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import entite.Groupe;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jakk
 */
public class GroupeUI extends JFrame{
    private final Groupe groupe;
    private JTextField id;
    private JTextField nom;
    private JTextField description;
    private JButton boutonEnregistrer;
    
    public GroupeUI(Groupe groupe){
        this.groupe = groupe;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        this.add(ajouterPanel());
        this.setVisible(true);
    }
    
    public final JPanel ajouterPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.ipadx = 10;
        gbc.ipady = 10;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Id"), gbc);
        gbc.gridx = 1;
        id = new JTextField(15);
        panel.add(id, gbc);
        
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
        panel.add(boutonEnregistrer,gbc);
        
        return panel;
    }
    
    public void modifierGroupe(){
        this.groupe.setId(Integer.parseInt(id.getText()));
        this.groupe.setNom(nom.getText());
        this.groupe.setDescription(description.getText());
    }
    
    public Groupe getGroupe(){
        return groupe;
    }
    
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
    }
    
}
