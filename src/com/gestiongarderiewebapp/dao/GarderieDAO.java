package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Garderie;
import com.gestiongarderiewebapp.bean.DbConnectionProvider;

import java.sql.*;

public class GarderieDAO {
    private DbConnectionProvider dbc = new DbConnectionProvider();
    private Statement st;

    public void AfficherGarderie()
    {
            try {
                 st = dbc.getConnection().createStatement();
                ResultSet rst = st.executeQuery("SELECT * FROM Garderie");

                while(rst.next()) {
                    System.out.println("Garderie N° : " + rst.getInt("idGard") + " Nom : " + rst.getString("NameGard") + " Capacité:  " + rst.getString("capGard"));
                }

            } catch (SQLException e) {
                System.err.println("Erreur" + e.getMessage());
            }
    }

    public static void main(String[] args) {
        GarderieDAO GrDAO = new GarderieDAO();
        GrDAO.AfficherGarderie();
    }
}
