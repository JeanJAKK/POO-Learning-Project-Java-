/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import entite.Groupe;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import service.GroupeService;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class GroupeUI extends JPanel{
    private DefaultTableModel model;
    private final Groupe groupe;
    private JTextField nom;
    private JTextField description;
    
    public GroupeUI(Groupe groupe) throws ObjetNonTrouveException{
        this.groupe = groupe;
    }
    
    public JPanel chargerTable(){
        JPanel p = new JPanel(new BorderLayout());
        
        String[] columns = {"Id", "Nom", "Description"};
        model = new DefaultTableModel(columns, 0);
        
        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        
        p.add(scroll, BorderLayout.CENTER);
        
        chargerGroupe();
        return p;
    }
    
    private void chargerGroupe(){
        try {
            model.setRowCount(0);
            GroupeService service = new GroupeService();
            
            for(Groupe g : service.lister()){
                model.addRow(new Object[]{
                    g.getId(),
                    g.getNom(),
                    g.getDescription()
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final JPanel creerFormulaire(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.ipadx = 10;
        gbc.ipady = 10;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nom"), gbc);
        gbc.gridx = 1;
        nom =  new JTextField(15);
        panel.add(nom, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Description"), gbc);
        gbc.gridx = 1;
        description =  new JTextField(15);
        panel.add(description, gbc);
        
        return panel;
    }
    
    public void remplirFormulaire(Groupe groupe){
        nom.setText(groupe.getNom());
        description.setText(groupe.getDescription());
    }
    
    public void viderFormulaire(){
        nom.setText("");
        description.setText("");
    }
    
     public int recupererId(){
        while (true) {            
            try {
                String input = JOptionPane.showInputDialog(this, "Veuillez Renseigner l'Id: ");
                int parseInt = Integer.parseInt(input.trim());
                return parseInt;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrer un entier valide!");
            }
        }
    }
     
    public Groupe getGroupe(){
        return groupe;
    }
    
    public void modifierGroupe()throws ObjetNonTrouveException{
        if(nom.getText().trim().equals("")){
            throw new ObjetNonTrouveException("Nom requis");
        }
        
        this.groupe.setNom(nom.getText().trim());
        this.groupe.setDescription(description.getText().trim());
    }
    
}
