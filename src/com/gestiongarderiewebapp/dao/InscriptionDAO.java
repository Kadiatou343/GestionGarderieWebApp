package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Child;
import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.bean.Inscription;
import com.gestiongarderiewebapp.bean.Parent;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InscriptionDAO {
    private final Connection connection = new DbConnectionProvider().getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    private final String tableName = "Inscriptions";
    private ChildDAO childDAO = new ChildDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    /**
     * Obtenir tous les tuples de la taple
     *
     * @return ArrayList
     */
    public ArrayList<Inscription> getAllInscriptions() {
        ArrayList<Inscription> inscriptions = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName);
            rs = pst.executeQuery();
            while (rs.next()) {
                Child registeredChild = childDAO.getChildById(rs.getInt("NumChild"));
                Employee employeeWhoRegistered = employeeDAO.getById(rs.getInt("NumEmp"));
                inscriptions.add(new Inscription(registeredChild, employeeWhoRegistered,
                        rs.getDate("InscriptionDate").toLocalDate()));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
        return inscriptions;
    }

    /**
     * Obtenir une inscription par ses id
     * @param numEmp L'identifiant de l'employé qui a fait l'inscription
     * @param numChild L'identifiant de l'enfant inscrit
     * @return Inscription
     */
    public Inscription getInscriptionByIds(int numEmp, int numChild) {
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE NumEmp = ? AND NumChild = ?");
            pst.setInt(1, numEmp);
            pst.setInt(2,numChild);
            rs = pst.executeQuery();
            if (rs.next()) {
                Child registeredChild = childDAO.getChildById(rs.getInt("NumChild"));
                Employee employee = employeeDAO.getById(rs.getInt("NumEmp"));
                return new Inscription(registeredChild, employee,
                        rs.getDate("InscriptionDate").toLocalDate());
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
        return null;
    }

    /**
     * Créer une nouvelle inscription dans la table
     * @param inscription L'inscription à ajouter
     */
    public void createInscription(Inscription inscription) {

        try {
            pst = connection.prepareStatement("INSERT INTO " + this.tableName + " (NumEmp, NumChild, InscriptionDate) " +
                    "VALUES (?, ?, ?)");
            pst.setInt(1, inscription.getEmployee().getNumEmp());
            pst.setInt(2, inscription.getChild().getNumChild());
            Date inscriptionDate = Date.valueOf(inscription.getInscriptionDate());
            pst.setDate(3, inscriptionDate);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    public void deleteInscription(Inscription inscription){
        try {
            pst = connection.prepareStatement("DELETE FROM " + this.tableName + " " +
                    "WHERE NumEmp = ? AND NumChild = ? ");
            pst.setInt(1,inscription.getEmployee().getNumEmp());
            pst.setInt(2,inscription.getChild().getNumChild());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression : " + e.getMessage());
        }
    }
}
