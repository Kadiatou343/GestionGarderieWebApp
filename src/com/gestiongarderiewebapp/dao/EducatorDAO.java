package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Educator;
import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.util.EducatorDegrees;


import java.sql.*;
import java.util.ArrayList;

public class EducatorDAO extends EmployeeDAO{

    public ArrayList<Employee> getAll(){
        ArrayList<Employee> educators = new ArrayList<>();

        try {
            pst = connection.prepareStatement("SELECT * FROM " +this.tableName+ "WHERE EmpType = ?");
            pst.setString(1, "Educatrice");
            rs = pst.executeQuery();
            while (rs.next()){
                EducatorDegrees degree = EducatorDegrees.fromValue(rs.getString("Degree"));
                educators.add(new Educator(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"), degree, rs.getInt("NbrChildren")));
            }
        } catch (SQLException|IllegalArgumentException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }

        return educators;
    }

    public Educator getById(int numEmp){

        try {
            pst = connection.prepareStatement("SELECT * FROM " +this.tableName +
                    " WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, "Educatrice");
            pst.setInt(2, numEmp);
            rs = pst.executeQuery();
            if (rs.next()){
                EducatorDegrees degree = EducatorDegrees.fromValue(rs.getString("Degree"));
                return new Educator(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"), degree, rs.getInt("NbrChildren"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public Educator update(Educator educator){

        try {
            pst = connection.prepareStatement("UPDATE " +this.tableName+ " SET EmpLastName = ?, " +
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

    public void delete(Educator educator){
        try {
            pst = connection.prepareStatement("DELETE FROM " +this.tableName+ " WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, "Educatrice");
            pst.setInt(2, educator.getNumEmp());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void AfficherEducateur()
//    {
//        try {
//            st = dbc.getConnection().createStatement();
//            ResultSet rst = st.executeQuery("SELECT * FROM Educator");
//
//            while(rst.next()) {
//                System.out.println("Diplôme: " + rst.getString("degree") + "Nombre enfants: " + rst.getInt("nbrChildren"));
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Erreur" + e.getMessage());
//        }
//    }
//    public static void main(String[] args) {
//
//        EducatorDAO EdDAO = new EducatorDAO();
//       EdDAO.AfficherEducateur();
//    }
}
