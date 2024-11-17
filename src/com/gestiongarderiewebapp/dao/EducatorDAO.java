package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Educator;
import com.gestiongarderiewebapp.bean.DbConnectionProvider;

import java.sql.*;

public class EducatorDAO {
    private DbConnectionProvider dbc = new DbConnectionProvider();
    private Statement st;

    public void AfficherEducateur()
    {
        try {
            st = dbc.getConnection().createStatement();
            ResultSet rst = st.executeQuery("SELECT * FROM Educator");

            while(rst.next()) {
                System.out.println("Diplôme: " + rst.getString("degree") + "Nombre enfants: " + rst.getInt("nbrChildren"));
            }

        } catch (SQLException e) {
            System.err.println("Erreur" + e.getMessage());
        }
    }
    public static void main(String[] args) {

        EducatorDAO EdDAO = new EducatorDAO();
       EdDAO.AfficherEducateur();
    }
}
