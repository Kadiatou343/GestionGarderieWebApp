package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    protected Connection connection = new DbConnectionProvider().getConnection();
    protected PreparedStatement pst;
    protected ResultSet rs;
    protected String tableName = "Employes";

    /**
     * Obtenir tous les tuples de la table
     *
     * @return ArrayList
     */
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName);
            rs = pst.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    /**
     * Obtenir un employé par identifiantt
     *
     * @param numEmp L'identifiant de l'employé
     * @return Employee
     */
    public Employee getById(int numEmp) {
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE NumEmp = ?");
            pst.setInt(1, numEmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
