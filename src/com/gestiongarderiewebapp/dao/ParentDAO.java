package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Parent;
import com.gestiongarderiewebapp.bean.DbConnectionProvider;

import java.sql.*;

public class ParentDAO {
    private DbConnectionProvider dbc = new DbConnectionProvider();
    private Statement st;

    public void AfficherParent()
    {
        try {
            st = dbc.getConnection().createStatement();
            ResultSet rst = st.executeQuery("SELECT * FROM Parent");

            while(rst.next()) {
                System.out.println("Parent N°: " + rst.getInt("NumPar") + " Prénom: " +
                        rst.getString("ParFirstName") + " Nom:  " +
                        rst.getString("parLastName")  + "Telephone: "
                        + rst.getString("phoneNumber"));
            }

        } catch (SQLException e) {
            System.err.println("Erreur" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ParentDAO PaDAO = new ParentDAO();
        PaDAO.AfficherParent();
    }
}
