package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Child;
import com.gestiongarderiewebapp.bean.DbConnectionProvider;

import java.sql.*;

public class ChildDAO {
    private DbConnectionProvider dbc = new DbConnectionProvider();
    private Statement st;

    public void AfficherEnfant()
    {
        try {
            st = dbc.getConnection().createStatement();
            ResultSet rst = st.executeQuery("SELECT * FROM Child");

            while(rst.next()) {
                System.out.println("Enfant N°: " + rst.getInt("numChild") + " Prénom: " +
                        rst.getString("childFirstName") + " Nom:  " +
                        rst.getString("childLastName")  + "Age: "
                        + rst.getString("childAge")+ "\n" + rst.getString("parent"));
            }

        } catch (SQLException e) {
            System.err.println("Erreur" + e.getMessage());
        }
    }
}
