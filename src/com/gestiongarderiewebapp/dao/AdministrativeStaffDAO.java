package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.AdministrativeStaff;
import com.gestiongarderiewebapp.bean.Employee;

import java.sql.*;
import java.util.ArrayList;

public class AdministrativeStaffDAO extends EmployeeDAO{

    public ArrayList<Employee> getAll(){
        ArrayList<Employee> staffAdmins = new ArrayList<>();
        try {
            pst = connection.prepareStatement("SELECT * FROM "+this.tableName+ " WHERE EmpType = ?");
            pst.setString(1, "Administratif");
            rs = pst.executeQuery();
            while (rs.next()) {
                staffAdmins.add(new AdministrativeStaff(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"), rs.getString("PhoneNum"), rs.getString("EmailProf")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return staffAdmins;
    }

    public AdministrativeStaff getById(int numEmp){

        try {
            pst = connection.prepareStatement("SELECT * FROM "+this.tableName+ " WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, "Administratif");
            pst.setInt(2, numEmp);
            rs = pst.executeQuery();
            if (rs.next()){
                return new AdministrativeStaff(rs.getInt("NumEmp"), rs.getString("EmpLastName"),
                        rs.getString("EmpFirstName"), rs.getString("PhoneNum"), rs.getString("EmailProf"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public AdministrativeStaff update(AdministrativeStaff staff){

        try {
            pst = connection.prepareStatement("UPDATE " +this.tableName+ " SET EmpLastName = ?, " +
                    "EmpFirstName = ?, PhoneNum = ?, EmailProf = ? WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, staff.getEmpLastName());
            pst.setString(2, staff.getEmpFirstName());
            pst.setString(3, staff.getPhoneNumber());
            pst.setString(4, staff.getEmailProf());
            pst.setString(5, "Administratif");
            pst.setInt(6, staff.getNumEmp());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.getById(staff.getNumEmp());
    }

    public void delete(AdministrativeStaff staff){
        try {
            pst = connection.prepareStatement("DELETE FROM " +this.tableName+ " WHERE EmpType = ? AND NumEmp = ?");
            pst.setString(1, "Administratif");
            pst.setInt(2, staff.getNumEmp());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    public void AfficherAdminisatateur()
//    {
//        try {
//            st = dbc.getConnection().createStatement();
//            ResultSet rst = st.executeQuery("SELECT * FROM AdministrativeStaff");
//
//            while(rst.next()) {
//                System.out.println("Téléphone: " + rst.getInt("phonenumber") + "Prof : " + rst.getString("emailProf"));
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Erreur" + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        AdministrativeStaffDAO AdDAO = new AdministrativeStaffDAO();
//        AdDAO.AfficherAdminisatateur();
//    }
}
