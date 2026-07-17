/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.jdi.ObjectCollectedException;
import entite.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class UtilisateurDao {

    private final Connection connexion;

    public UtilisateurDao() {
        this.connexion = Connexion.getConnexion();
    }

    public void ajouter(Utilisateur utilisateur) {
        String sql = "INSERT INTO UTILISATEURS(identifiant, mot_de_passe)"
                + " VALUES (?, ?)";
        try {
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setString(1, utilisateur.getIdentifiant());
            etat.setString(2, utilisateur.getMotDePasse());
            etat.executeUpdate();

            etat.close();
            connexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Utilisateur trouver(int id) throws ObjetNonTrouveException, SQLException {
        String sql = "SELECT * FROM UTILISATEURS WHERE ID = ?";
        try {
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setInt(1, id);
            ResultSet resultat = etat.executeQuery();
            if (resultat.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultat.getInt(1));
                utilisateur.setIdentifiant(resultat.getString(2));

                return utilisateur;
            } else {
                throw new ObjetNonTrouveException("Utilisateur avec id = "
                        + String.valueOf(id) + " non trouvé");
            }
        } catch (SQLException ex) {
            throw ex;
        }
        //return null;
    }

    public Utilisateur trouver(String identifiant) {
        return null;
    }

    public List<Utilisateur> lister() {
        return null;
    }

    public Utilisateur modifier(Utilisateur utilisateur) {
        String sql = "UPDATE UTILISATEURS SET identifiant = ? "
                + ", mot_de_passe = ? "
                + "WHERE id = ? ";
        try {
            PreparedStatement etat = connexion.prepareStatement(sql);
            etat.setString(1, utilisateur.getIdentifiant());
            etat.setString(2, utilisateur.getMotDePasse());
            etat.setInt(3, utilisateur.getId());
            etat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            return this.trouver(utilisateur.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void supprimer(Utilisateur utilisateur) {

    }

    public void supprimer(int id) {

    }

    public void supprimer(String identifiant) {

    }

}