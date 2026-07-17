/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc1;

import entite.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import presentation.controleur.UtilisateurControleur;

/**
 *
 * @author jakk
 */
public class Jdbc1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        UtilisateurControleur utilisateurControlleur = new UtilisateurControleur();
        utilisateurControlleur.modifier(3);
    }
    
     private static void connexionUtilisateur(){
        String login= "toto";
       // String motDePasse= "123123";
        String motDePasse="1' OR '1'='1";
        Connection connexion = getConnection();
        String sql = "SELECT * FROM utilisateurs WHERE identifiant ='" + login +"' " 
                + "AND mot_de_passe =' " + motDePasse +"';";
        System.out.println(sql);
            try{
                Statement etat = connexion.createStatement();
                ResultSet resultat = etat.executeQuery(sql);
                if(resultat.next()){
                     System.out.println("Connexion effectuée avec succès");
                    //System.out.println("id = " + resultat.getString(1));
                    //System.out.println("identifiant = " + resultat.getString(2));
                } else{
                System.out.println("Identifiant ou mot de passe incorrect.");
              }
                etat.close();
                connexion.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }finally{
                
            }
    }
     
     private static void connexionUtilisateurV2(){
        String login= "user1";
        String motDePasse= "123123";
       // en jdbc les indices commencent par 1 ;
        //String motDePasse="1' OR '1'='1";
        Connection connexion = getConnection();
        String sql = "SELECT * FROM utilisateurs WHERE identifiant =? " 
                + "AND mot_de_passe =' ?";
       // System.out.println(sql);
            try{
                PreparedStatement etat = connexion.prepareStatement(sql);
                etat.setString(1, login);
                etat.setString(2, motDePasse);
       
                ResultSet resultat = etat.executeQuery();
                if(resultat.next()){
                     System.out.println("Connexion effectuée avec succès");
                    //System.out.println("id = " + resultat.getString(1));
                    //System.out.println("identifiant = " + resultat.getString(2));
                } else{
                System.out.println("Identifiant ou mot de passe incorrect.");
              }
                etat.close();
                connexion.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }finally{
                
            }
     }
           
    private static void connexionUtilisateurV3(){
        Utilisateur utilisateur = new Utilisateur("user1", "123123");
       // String motDePasse= "123123"
       // en jdbc les indices commencent par 1 ;
        //String motDePasse="1' OR '1'='1";
        Connection connexion = getConnection();
        String sql = "SELECT * FROM utilisateurs WHERE identifiant =? " 
                + "AND mot_de_passe =' ?";
       // System.out.println(sql);
            try{
                PreparedStatement etat = connexion.prepareStatement(sql);
                etat.setString(1,utilisateur.getIdentifiant());
                etat.setString(2,utilisateur.getMotDePasse());
       
                ResultSet resultat = etat.executeQuery();
                if(resultat.next()){
                     System.out.println("Connexion effectuée avec succès");
                    //System.out.println("id = " + resultat.getString(1));
                    //System.out.println("identifiant = " + resultat.getString(2));
                } else{
                System.out.println("Identifiant ou mot de passe incorrect.");
              }
                etat.close();
                connexion.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }finally{
                
            }
    }
    
    
    private static Utilisateur trouver(int id){
    Connection connexion = getConnection();
    String sql = "SELECT * FROM utilisateurs WHERE id = 1";
            try{
                 Utilisateur utilisateur = new Utilisateur();
                PreparedStatement etat = connexion.prepareStatement(sql);
                etat.setInt(1, 3);
                ResultSet resultat = etat.executeQuery();
                if(resultat.next()){
                   
                    utilisateur.setId(resultat.getInt(1));
                    utilisateur.setIdentifiant(resultat.getString(2));
                    
                }
                etat.close();
                connexion.close();
                return utilisateur; 
            }catch(SQLException e){
                System.out.println(e.getMessage());
                return null;
            }finally{
                
            }
   }
   private static Utilisateur trouver(String identifiant){
    Connection connexion = getConnection();
    String sql = "SELECT * FROM utilisateurs WHERE identifiant = ?";
            try{
                 Utilisateur utilisateur = new Utilisateur();
                PreparedStatement etat = connexion.prepareStatement(sql);
                etat.setString(1, identifiant);
                ResultSet resultat = etat.executeQuery();
                if(resultat.next()){
                   
                    utilisateur.setId(resultat.getInt(1));
                    utilisateur.setIdentifiant(resultat.getString(2));
                    
                }
                etat.close();
                connexion.close();
                return utilisateur; 
            }catch(SQLException e){
                System.out.println(e.getMessage());
                return null;
            }finally{
                
            }
   }
   
    private static void trouver(){
    Connection connexion = getConnection();
    String sql = "SELECT * FROM utilisateurs WHERE id = ?";
            try{
                Statement etat = connexion.createStatement();
                ResultSet resultat = etat.executeQuery(sql);
                if(resultat.next()){
                    System.out.println("id = " + resultat.getString(1));
                    System.out.println("identifiant = " + resultat.getString(2));
                }
                etat.close();
                connexion.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }finally{
                
            }

}
    
    public static void ajouter(Utilisateur utilisateur){
        Connection connexion = getConnection();
        String sql = "INSERT INTO utilisateurs(identifiant, mot_de_passe) "
                + " VALUES ('? '?)";
        try {
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setString(1, utilisateur.getIdentifiant());
            etat.setString(2, utilisateur.getMotDePasse());
            int nombreLignes = etat.executeUpdate();
            System.out.println("Opération effectuée avec succès: " + nombreLignes + "lignes(s) ajoutée(s)");
            //etat.execute(sql);
            etat.close();
            connexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 
    }           
    
    private static void ajouter (){
    Connection connexion = getConnection();
        String sql = "INSERT INTO utilisateurs(identifiant, mot_de_passe) "
                + " VALUES ('user3', '123123')";
        try {
            Statement etat = connexion.createStatement();
            etat.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

}
    
    private static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String login = "jdbc";
        String motDePasse = "123456789";
        try {
            Connection connexion = DriverManager.getConnection(url, login, motDePasse);
            // System.out.println("Connexion effectuée avec succès");
            return connexion;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}