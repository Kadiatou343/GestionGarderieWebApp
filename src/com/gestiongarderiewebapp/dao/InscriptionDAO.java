package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Child;
import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.bean.Inscription;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.time.ZoneId;
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
     * Obtenir toutes les inscriptions faites par un employé specifique
     *
     * @param employee L'employé specifié
     * @return ArrayList
     */
    public ArrayList<Inscription> getInscriptionsByEmployee(Employee employee) {
        ArrayList<Inscription> inscriptions = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName + " WHERE NumEmp = ?");
            pst.setInt(1, employee.getNumEmp());
            rs = pst.executeQuery();
            while (rs.next()) {
                Child registeredChild = childDAO.getChildById(rs.getInt("NumChild"));
                inscriptions.add(new Inscription(registeredChild, employee,
                        rs.getDate("InscriptionDate").toLocalDate()));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
        return inscriptions;
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
            Date inscriptionDate = (Date) Date.from(inscription.getInscriptionDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            pst.setDate(3, inscriptionDate);

            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout : " + e.getMessage());
        }
    }

}
