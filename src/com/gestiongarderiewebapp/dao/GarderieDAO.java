package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Garderie;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe représentant la classe d'accès aux données de Garderie
 */
public class GarderieDAO {
    private Connection connection = DbConnectionProvider.getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    private String tableName = "Garderies";

    /**
     * Recuperer de tous les tuples de la table
     *
     * @return ArrayList
     */
    public ArrayList<Garderie> getAll() {
        ArrayList<Garderie> garderies = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName);
            rs = pst.executeQuery();

            while (rs.next()) {
                garderies.add(new Garderie(rs.getInt("IdGard"), rs.getString("NameGard"), rs.getInt("CapGard")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return garderies;
    }

    /**
     * Recuperer un tuple par son id
     *
     * @param idGard L'identifiant de la garderie
     * @return Garderie
     */
    public Garderie getById(int idGard) {
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE IdGard = ?");
            pst.setInt(1, idGard);
            rs = pst.executeQuery();

            return new Garderie(rs.getInt("IdGard"), rs.getString("NameGard"),
                    rs.getInt("CapGard"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Mettre à jour une garderie
     *
     * @param garderie la garderie à mettre à jour
     * @return Garderie
     */
    public Garderie update(Garderie garderie) {
        try {
            pst = connection.prepareStatement("UPDATE " + this.tableName + " SET NameGard = ?, CapGard = ?");
            pst.setString(1, garderie.getNameGard());
            pst.setInt(2, garderie.getCapGard());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.getById(garderie.getIdGard());
    }

    /**
     * Supprimer une garderie
     *
     * @param garderie La garderie à supprimer
     */
    public void delete(Garderie garderie) {
        try {
            pst = connection.prepareStatement("DELETE FROM " + this.tableName + " WHERE IdGard = ?");
            pst.setInt(1, garderie.getIdGard());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void AfficherGarderie()
//    {
//            try {
//                 st = dbc.getConnection().createStatement();
//                ResultSet rst = st.executeQuery("SELECT * FROM Garderie");
//
//                while(rst.next()) {
//                    System.out.println("Garderie N° : " + rst.getInt("idGard") + " Nom : " + rst.getString("NameGard") + " Capacité:  " + rst.getString("capGard"));
//                }
//
//            } catch (SQLException e) {
//                System.err.println("Erreur" + e.getMessage());
//            }
//    }
//
//    public static void main(String[] args) {
//        GarderieDAO GrDAO = new GarderieDAO();
//        GrDAO.AfficherGarderie();
//    }
}