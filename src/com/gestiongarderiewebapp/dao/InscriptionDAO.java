package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Inscription;
import com.gestiongarderiewebapp.bean.DbConnectionProvider;

import java.sql.*;

public class InscriptionDAO {
    private DbConnectionProvider dbc = new DbConnectionProvider();
    private Statement st;

    public void AfficherInscription()
    {
        try {
            st = dbc.getConnection().createStatement();
            ResultSet rst = st.executeQuery("SELECT * FROM Inscription");

            while(rst.next()) {
                System.out.println("Inscription: " + rst.getString("child") + " Date Inscription: " + rst.getString("inscriptionDate"));
            }

        } catch (SQLException e) {
            System.err.println("Erreur" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        InscriptionDAO InDAO = new InscriptionDAO();
        InDAO.AfficherInscription();
    }
}
