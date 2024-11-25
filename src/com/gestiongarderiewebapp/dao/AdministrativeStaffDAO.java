package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.AdministrativeStaff;
import com.gestiongarderiewebapp.bean.Employee;

import java.sql.*;
import java.util.ArrayList;

public class AdministrativeStaffDAO extends EmployeeDAO {

    /**
     * Obetenir tous les tuples de la table
     * @return ArrayList
     */
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> staffAdmins = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE EmpType = ?");
            pst.setString(1, "Administratif");
            rs = pst.executeQuery();
            while (rs.next()) {
                staffAdmins.add(new AdministrativeStaff(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"), rs.getString("PasswordHash"),
                        rs.getString("PhoneNum"), rs.getString("EmailProf")));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
        return staffAdmins;
    }

    /**
     * Obtenir un personnel admin par son identifiant
     * @param numEmp L'identifiant du personnel admin
     * @return ArrayList
     */
    public AdministrativeStaff getById(int numEmp) {

        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, "Administratif");
            pst.setInt(2, numEmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                return new AdministrativeStaff(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"), rs.getString("PasswordHash"),
                        rs.getString("PhoneNum"), rs.getString("EmailProf"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
        return null;
    }

    /**
     * Créer un nouveau personnel admin dans la table
     * @param staffAdmin Le personnel admin à ajouter
     */
    public void createStaffAdmin(AdministrativeStaff staffAdmin) {
        try {
            pst = connection.prepareStatement("INSERT INTO " + this.tableName + " (EmpLastName, EmpFirstName, PasswordHash, EmpType, PhoneNum, EmailProf, IdGard) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, staffAdmin.getEmpLastName());
            pst.setString(2, staffAdmin.getEmpFirstName());
            pst.setString(3, staffAdmin.getPasswordHash());
            pst.setString(4, "Administratif");
            pst.setString(5, staffAdmin.getPhoneNumber());
            pst.setString(6, staffAdmin.getEmailProf());
            pst.setInt(7, 1);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    /**
     * Mettre à jour un personnel admin
     * @param staffAdmin Le personnel admin à mettre à jour
     * @return AdministrativeStaff
     */
    public AdministrativeStaff update(AdministrativeStaff staffAdmin) {

        try {
            pst = connection.prepareStatement("UPDATE " + this.tableName + " SET EmpLastName = ?, " +
                    "EmpFirstName = ?, PasswordHash = ?, PhoneNum = ?, EmailProf = ? WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, staffAdmin.getEmpLastName());
            pst.setString(2, staffAdmin.getEmpFirstName());
            pst.setString(3, staffAdmin.getPasswordHash());
            pst.setString(4, staffAdmin.getPhoneNumber());
            pst.setString(5, staffAdmin.getEmailProf());
            pst.setString(6, "Administratif");
            pst.setInt(7, staffAdmin.getNumEmp());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour : " + e.getMessage());
        }

        return this.getById(staffAdmin.getNumEmp());
    }

    /**
     * Supprimer un personnel admin de la table
     * @param staffAdmin Le personnel admin à supprimer
     */
    public void delete(AdministrativeStaff staffAdmin) {
        try {
            pst = connection.prepareStatement("DELETE FROM " + this.tableName + " WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, "Administratif");
            pst.setInt(2, staffAdmin.getNumEmp());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }

}
