package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Educator;
import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.util.EducatorDegrees;


import java.sql.*;
import java.util.ArrayList;

public class EducatorDAO extends EmployeeDAO {

    /**
     * Obtenir toutes les éducatrices de la table
     *
     * @return ArrayList
     */
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> educators = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + "WHERE EmpType = ?");
            pst.setString(1, "Educatrice");
            rs = pst.executeQuery();
            while (rs.next()) {
                EducatorDegrees degree = EducatorDegrees.fromValue(rs.getString("Degree"));
                educators.add(new Educator(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"), degree, rs.getInt("NbrChildren")));
            }
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }

        return educators;
    }

    /**
     * Obtenir une éducatrice par son identifiant
     *
     * @param numEmp L'identifiant de l'educatrice
     * @return Educator (Nullable si il n'y a aucune correspondance)
     */
    public Educator getById(int numEmp) {

        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName +
                    " WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, "Educatrice");
            pst.setInt(2, numEmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                EducatorDegrees degree = EducatorDegrees.fromValue(rs.getString("Degree"));
                return new Educator(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"), degree, rs.getInt("NbrChildren"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    /**
     * Créer une éducatrice dans la table
     *
     * @param educator L'éducatrice à ajouter
     */
    public void createEducator(Educator educator) {
        try {
            pst = connection.prepareStatement("INSERT INTO " + this.tableName + " (EmpLastName, EmpFirstName, EmpType, Degree, NbrChildren, IdGard) " +
                    "VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, educator.getEmpLastName());
            pst.setString(2, educator.getEmpFirstName());
            pst.setString(3, "Educatrice");
            pst.setString(4, educator.getDegree().getValue());
            pst.setInt(5, educator.getNbrChildren());
            pst.setInt(6, 1);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    /**
     * Mettre à jour une éducatrice dans la table
     *
     * @param educator L'éducatrice à mettre à jour
     */
    public Educator update(Educator educator) {

        try {
            pst = connection.prepareStatement("UPDATE " + this.tableName + " SET EmpLastName = ?, " +
                    "EmpFirstName = ?, Degree = ?, NbrChildren = ? WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, educator.getEmpLastName());
            pst.setString(2, educator.getEmpFirstName());
            pst.setString(3, educator.getDegree().getValue());
            pst.setInt(4, educator.getNbrChildren());
            pst.setString(5, "Educatrice");
            pst.setInt(6, educator.getNumEmp());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.getById(educator.getNumEmp());
    }

    /**
     * Supprimer une éducatrice de la table
     *
     * @param educator L'éducatrice de la table
     */
    public void delete(Educator educator) {
        try {
            pst = connection.prepareStatement("DELETE FROM " + this.tableName + " WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, "Educatrice");
            pst.setInt(2, educator.getNumEmp());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
