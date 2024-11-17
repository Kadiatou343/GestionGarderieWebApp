package com.gestiongarderiewebapp.util;

import java.sql.*;

/**
 * Classe représentant le fournisseur de la connexion à la base de données
 */
public class DbConnectionProvider {
    /**
     * Les informations de connexion à la base de données
     */
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "sys as sysdba";
    private static final String PASSWORD = "123";

    /**
     * La méthode statique qui retourne la connexion ou null si une erreur se produit
     * @return Connection
     */
    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Echec de connexion : " +e.getMessage());
        }
        return null;
    }
}
