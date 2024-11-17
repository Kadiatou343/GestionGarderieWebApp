package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.bean.DbConnectionProvider;

import java.sql.*;

public class EmployeeDAO {
    private DbConnectionProvider dbc = new DbConnectionProvider();
    private Statement st;

    public void AfficherEmployee()
    {
        try {
            st = dbc.getConnection().createStatement();
            ResultSet rst = st.executeQuery("SELECT * FROM Employee");

            while(rst.next()) {
                System.out.println("Employé N° : " + rst.getInt("numEmp") + " Prénom: " + rst.getString("empFirstName") + " Nom: " + rst.getString("empLastName"));
            }

        } catch (SQLException e) {
            System.err.println("Erreur" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EmployeeDAO EmDAO = new EmployeeDAO();
        EmDAO.AfficherEmployee();
    }
}
