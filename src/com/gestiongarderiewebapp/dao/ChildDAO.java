package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Child;
import com.gestiongarderiewebapp.bean.Parent;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class ChildDAO {
    private final Connection connection = new DbConnectionProvider().getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    private final String tableName = "Children";
    private ParentDAO parentDAO = new ParentDAO();

    /**
     * Recupérer tous les tuples de la table
     *
     * @return ArrayList
     */
    public ArrayList<Child> getAllChildren() {
        ArrayList<Child> children = new ArrayList<>();

        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName);
            rs = pst.executeQuery();
            while (rs.next()) {
                Parent parent = parentDAO.getParentById(rs.getInt("NumPar"));
                children.add(new Child(rs.getInt("NumChild"), rs.getString("ChildLastName"),
                        rs.getString("ChildFirstName"), rs.getInt("ChildAge"), parent));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return children;
    }

    /**
     * Obtenir un enfant par son identifiant
     *
     * @param numChild L'identifiant de l'enfant
     * @return Child
     */
    public Child getChildById(int numChild) {

        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE NumChild = ?");
            pst.setInt(1, numChild);
            rs = pst.executeQuery();
            Parent parent = parentDAO.getParentById(rs.getInt("NumPar"));
            return new Child(rs.getInt("NumChild"), rs.getString("ChildLastName"),
                    rs.getString("ChildFirstName"), rs.getInt("ChildAge"), parent);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Créer un enfant dans la table
     *
     * @param child L'enfant à ajouter
     */
    public void createChild(Child child) {
        try {
            pst = connection.prepareStatement("INSERT INTO " + this.tableName + " (ChildLastName, ChildFirstName, ChildAge, NumPar, IdGard) " +
                    "VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, child.getChildLastName());
            pst.setString(2, child.getChildFirstName());
            pst.setInt(3, child.getChildAge());
            pst.setInt(4, child.getParent().getNumPar());
            pst.setInt(5, 1);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    /**
     * Mettre à jour un enfant
     *
     * @param child l'enfant à mettre à jour
     * @return Child
     */
    public Child update(Child child) {

        try {
            pst = connection.prepareStatement("UPDATE " + this.tableName + " SET " +
                    "ChildLastName = ?, ChildFirstName = ?, ChildAge = ?, NumPar = ? " +
                    "WHERE NumChild = ?");
            pst.setString(1, child.getChildLastName());
            pst.setString(2, child.getChildFirstName());
            pst.setInt(3, child.getChildAge());
            pst.setInt(4, child.getParent().getNumPar());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.getChildById(child.getNumChild());
    }

    /**
     * Supprimer un enfant
     *
     * @param child l'enfant à supprimer
     */
    public void delete(Child child) {

        try {
            pst = connection.prepareStatement("DELETE FROM " + this.tableName + " WHERE NumChild = ?");
            pst.setInt(1, child.getNumChild());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
