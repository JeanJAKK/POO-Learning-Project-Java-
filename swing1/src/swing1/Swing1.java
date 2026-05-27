/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package swing1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author jakk
 */
public class Swing1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creerJDialog();
      
        //JOptionPane.showMessageDialog(null, "Opération bien éffecuée");
        //creerJWindow();
        //creerJPanel_old();
        gererEvenements();
    }
    
    public static void gererEvenements() {
        MaFenetre fenetre = new MaFenetre();
        JButton boutonAjouter = new JButton("Ajouter");
        JButton boutonModifier = new JButton("Modifier");
        
        //Ajout d'écouteur
        EcouteurBoutonAjouter ec1 = new EcouteurBoutonAjouter();
        boutonAjouter.addActionListener(ec1);
        //boutonModifier.addActionListener(ec1);
        
//        ActionListener ec2 = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                System.out.println("Bouton 'Modifier' sélectionné");
//            }
//        };
//        //ActionListener ec3 = event -> {System.out.println("Bouton 'Modifier'sélectionné");};
//        ActionListener ec3 = event -> {System.out.println(event.getActionCommand());};

        boutonModifier.addActionListener(event -> {System.out.println(event.getActionCommand());});
        
        
        JPanel panel = new JPanel();
        panel.add(boutonModifier);
        panel.add(boutonAjouter);
        fenetre.add(panel);
        fenetre.setVisible(true);
    }
    
    public static void creerJPanel() {
        MaFenetre fenetre = new  MaFenetre();
//        
//        JPanel panel1 = new JPanel();
//        panel1.setBackground(Color.red);
//        for (int i = 1; i <= 40; i++ ){
//            panel1.add(new JButton("Bouton" + i));
//        }
//                
//        JScrollPane jScrollPane = new JScrollPane(panel1);
        MonPanneau panneau = new MonPanneau();
        
        fenetre.add(panneau);
    }
    
    public static void creerJPanel_old() {
        JFrame fenetre = new JFrame("Application swing1");
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetre.setSize(400, 300);
        
        JPanel panel1 = new JPanel();
        //FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
        //BorderLayout borderLayout = new BorderLayout();
        GridLayout gridLayout= new GridLayout(3, 2);
        panel1.setLayout(gridLayout);
//        JButton boutonNord = new JButton("Bouton Nord");
//        JButton boutonSud = new JButton("Bouton Sud");
//        JButton boutonEst = new JButton("Bouton Est");
//        JButton boutonOuest = new JButton("Bouton Ouest");
//        JButton boutonCentre = new JButton("Bouton Centre");

        
//        panel1.setBackground(Color.red);JButton
        for (int i = 1; i <= 12; i++ ){
            panel1.add(new JButton("Bouton" + i));
        }

//        panel1.add(boutonCentre);
//        panel1.add(boutonNord, BorderLayout.NORTH);
//        panel1.add(boutonSud, BorderLayout.SOUTH);
//        panel1.add(boutonOuest, BorderLayout.WEST);
//        panel1.add(boutonEst, BorderLayout.EAST);
//

        fenetre.add(panel1);
        fenetre.setVisible(true);
    }
    
    public static void creerJWindow() {
        JWindow w = new JWindow();
        w.setSize(300, 300);
        w.setLocation(500, 100);
        w.setVisible(true);
    }
    
    public static void creerJDialog(){
        JDialog dialogie = new JDialog();
        dialogie.setSize(300, 150);
        dialogie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialogie.setTitle("Opération en cours ....");
        dialogie.setVisible(true);
    }
    
    public static void creerJFrame(){
        // TODO code application logic here
        
//        JFrame fenetre1 = new JFrame();
//        fenetre1.setSize(500, 300);
//        fenetre1.setTitle("fenetre1");
//        fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fenetre1.setVisible(true);


        JButton bouton1 = new JButton("Premier boutton");
        JFrame fenetre2 = new JFrame();
        fenetre2.setSize(500, 300);
        fenetre2.setTitle("fenetre2");
        fenetre2.add(bouton1);
        fenetre2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetre2.setVisible(true);
    }
    
}