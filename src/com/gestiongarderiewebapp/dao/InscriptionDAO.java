package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Child;
import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.bean.Inscription;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class InscriptionDAO {
    private final Connection connection = new DbConnectionProvider().getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    private final String tableName = "Inscriptions";
    private ChildDAO childDAO = new ChildDAO();
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public ArrayList<Inscription> getAll(){
        ArrayList<Inscription> inscriptions = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM "+this.tableName);
            rs = pst.executeQuery();
            while (rs.next()){
                Child registeredChild = childDAO.getById(rs.getInt("NumChild"));
                Employee employeeWhoRegistered = employeeDAO.getById(rs.getInt("NumEmp"));
                inscriptions.add(new Inscription(registeredChild, employeeWhoRegistered,
                        rs.getDate("InscriptionDate").toLocalDate()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inscriptions;
    }

    public ArrayList<Inscription> getByEmployee(Employee employee){
        ArrayList<Inscription> inscriptions = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " +this.tableName+ " WHERE NumEmp = ?");
            pst.setInt(1, employee.getNumEmp());
            rs = pst.executeQuery();
            while (rs.next()){
                Child registeredChild = childDAO.getById(rs.getInt("NumChild"));
                inscriptions.add(new Inscription(registeredChild, employee,
                        rs.getDate("InscriptionDate").toLocalDate()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return inscriptions;
    }





//    public void AfficherInscription()
//    {
//        try {
//            st = dbc.getConnection().createStatement();
//            ResultSet rst = st.executeQuery("SELECT * FROM Inscription");
//
//            while(rst.next()) {
//                System.out.println("Inscription: " + rst.getString("child") + " Date Inscription: " + rst.getString("inscriptionDate"));
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Erreur" + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        InscriptionDAO InDAO = new InscriptionDAO();
//        InDAO.AfficherInscription();
//    }
}
