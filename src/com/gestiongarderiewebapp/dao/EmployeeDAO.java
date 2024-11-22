package com.gestiongarderiewebapp.dao;
import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    protected Connection connection = new DbConnectionProvider().getConnection();
    protected PreparedStatement pst;
    protected ResultSet rs;
    protected String tableName = "Employes";

    public ArrayList<Employee> getAll(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM " +this.tableName);
            rs = pst.executeQuery();
            while (rs.next()){
                employees.add(new Employee(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public Employee getById(int numEmp){
        try {
            pst = connection.prepareStatement("SELECT * FROM "+this.tableName+ " WHERE NumEmp = ?");
            pst.setInt(1,numEmp);
            rs = pst.executeQuery();
            if (rs.next()){
                return new Employee(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



//    public void AfficherEmployee()
//    {
//        try {
//            st = dbc.getConnection().createStatement();
//            ResultSet rst = st.executeQuery("SELECT * FROM Employee");
//
//            while(rst.next()) {
//                System.out.println("Employé N° : " + rst.getInt("numEmp") + " Prénom: " + rst.getString("empFirstName") + " Nom: " + rst.getString("empLastName"));
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Erreur" + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        EmployeeDAO EmDAO = new EmployeeDAO();
//        EmDAO.AfficherEmployee();
//    }
}
