package com.gestiongarderiewebapp.util;

import java.sql.*;

/**
 * Classe représentant le fournisseur de la connexion à la base de données
 */
public class DbConnectionProvider {
    /**
     * La connexion elle-même
     */
    private Connection connection;
    /**
     * L'url de connexion à la base de données
     */
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    /**
     * Le nom d'utilisateur de connexion à la base de données
     */
    private static final String USERNAME = "GestionGarderie";
    /**
     * Le mot de passe de connexion à la base de données
     */
    private static final String PASSWORD = "123";

    public DbConnectionProvider(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
           this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            System.out.println("Connexion succes");
        } catch (SQLException|ClassNotFoundException e) {
            System.err.println("Echec de connexion : " +e.getMessage());
        }
    }

    /**
     * La méthode statique qui retourne la connexion
     * @return Connection
     */
    public Connection getConnection()
    {
        return this.connection;
    }
}
