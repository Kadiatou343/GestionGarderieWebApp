package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.AdministrativeStaff;
import com.gestiongarderiewebapp.bean.DbConnectionProvider;

import java.sql.*;

public class AdministratifDAO {

    private DbConnectionProvider dbc = new DbConnectionProvider();
    private Statement st;

    public void AfficherAdminisatateur()
    {
        try {
            st = dbc.getConnection().createStatement();
            ResultSet rst = st.executeQuery("SELECT * FROM AdministrativeStaff");

            while(rst.next()) {
                System.out.println("Téléphone: " + rst.getInt("phonenumber") + "Prof : " + rst.getString("emailProf"));
            }

        } catch (SQLException e) {
            System.err.println("Erreur" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        AdministratifDAO AdDAO = new AdministratifDAO();
        AdDAO.AfficherAdminisatateur();
    }
}
