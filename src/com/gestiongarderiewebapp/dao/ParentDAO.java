package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Parent;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class ParentDAO {
    private Connection connection = DbConnectionProvider.getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    private String tableName = "Parents";

    public ArrayList<Parent> getAll() {
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

    public Parent getById(int numPar) {

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
        return this.getById(parent.getNumPar());
    }


    public void delete(Parent parent) {

        try {
            pst = connection.prepareStatement("DELETE FROM " + this.tableName + " WHERE NumPar = ?");
            pst.setInt(1, parent.getNumPar());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }

//    public void AfficherParent()
//    {
//        try {
//            st = dbc.getConnection().createStatement();
//            ResultSet rst = st.executeQuery("SELECT * FROM Parent");
//
//            while(rst.next()) {
//                System.out.println("Parent N°: " + rst.getInt("NumPar") + " Prénom: " +
//                        rst.getString("ParFirstName") + " Nom:  " +
//                        rst.getString("parLastName")  + "Telephone: "
//                        + rst.getString("phoneNumber"));
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Erreur" + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        ParentDAO PaDAO = new ParentDAO();
//        PaDAO.AfficherParent();
//    }
}
