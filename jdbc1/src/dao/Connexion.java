/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jakk
 */
public class Connexion {

    private static Connection connexion;

    static {
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String login = "jdbc";
        String motDePasse = "123456789";

        try {
            connexion = DriverManager.getConnection(url, login, motDePasse);
            //System.out.println("Connexion effectuee avec success");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public static Connection getConnexion() {
        return connexion;
    }
}