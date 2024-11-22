package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Parent;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class ParentDAO {
    private final Connection connection = new DbConnectionProvider().getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    private final String tableName = "Parents";

    /**
     * Obtenir tous les tuples de la table
     *
     * @return ArrayList
     */
    public ArrayList<Parent> getAllParents() {
        ArrayList<Parent> parents = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName);
            rs = pst.executeQuery();
            while (rs.next()) {
                parents.add(new Parent(rs.getInt("NumPar"), rs.getString("ParLastName"),
                        rs.getString("ParFirstName"), rs.getString("PhoneNum")));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche: " + e.getMessage());
        }

        return parents;
    }

    /**
     * Obtenir un parent par son identifiant
     *
     * @param numPar L'identifiant du parent
     * @return Parent
     */
    public Parent getParentById(int numPar) {
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE NumPar = ?");
            pst.setInt(1, numPar);
            rs = pst.executeQuery();

            return new Parent(rs.getInt("NumPar"), rs.getString("ParLastName"),
                    rs.getString("ParFirstName"), rs.getString("PhoneNum"));

        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche: " + e.getMessage());
        }
        return null;
    }

    /**
     * Créer un parent
     *
     * @param parent Le parent à créer
     */
    public void create(Parent parent) {
        try {
            pst = connection.prepareStatement("INSERT INTO " + this.tableName + " (ParLastName, ParFirstName, PhoneNum) " +
                    "VALUES (?, ?, ?)");
            pst.setString(1, parent.getParLastName());
            pst.setString(2, parent.getParFirstName());
            pst.setString(2, parent.getPhoneNumber());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout " + e.getMessage());
        }
    }

    /**
     * Mettre à jour un parent
     *
     * @param parent Le parent à mettre à jour
     * @return Parent
     */
    public Parent update(Parent parent) {

        try {
            pst = connection.prepareStatement("UPDATE " + this.tableName + " SET ParLastName = ?, " +
                    "ParFirstName = ?, PhoneNum = ? WHERE NumPar = ?");
            pst.setInt(1, parent.getNumPar());
            pst.setString(2, parent.getParLastName());
            pst.setString(3, parent.getParFirstName());
            pst.setString(4, parent.getPhoneNumber());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la mise à jour : " + e.getMessage());
        }
        return this.getParentById(parent.getNumPar());
    }


    /**
     * Supprimer un parent
     *
     * @param parent Le parent à supprimer
     */
    public void delete(Parent parent) {

        try {
            pst = connection.prepareStatement("DELETE FROM " + this.tableName + " WHERE NumPar = ?");
            pst.setInt(1, parent.getNumPar());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
