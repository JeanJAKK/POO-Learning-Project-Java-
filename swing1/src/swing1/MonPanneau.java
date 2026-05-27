/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing1;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author jakk
 */
public class MonPanneau extends JScrollPane{
    private final JPanel panel1;
    
    public MonPanneau(){
//        super(panel);
//        JScrollPane scrollPane = new JScrollPane(panel);
        
        panel1 = new JPanel();
        panel1.setBackground(Color.red);
        for (int i = 1; i <= 40; i++ ){
            panel1.add(new JButton("Bouton" + i));
        }
        
        this.setViewportView(panel1);
    }
    
}
