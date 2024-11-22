package com.gestiongarderiewebapp.dao;

import com.gestiongarderiewebapp.bean.Child;
import com.gestiongarderiewebapp.bean.Parent;
import com.gestiongarderiewebapp.util.DbConnectionProvider;

import java.sql.*;
import java.util.ArrayList;

public class ChildDAO {
    private Connection connection = DbConnectionProvider.getConnection();
    private PreparedStatement pst;
    private ResultSet rs;
    private String tableName = "Children";
    private ParentDAO parentDAO;

    /**
     * Recupérer tous les tuples de la table
     *
     * @return ArrayList
     */
    public ArrayList<Child> getAll() {
        ArrayList<Child> children = new ArrayList<>();

        try {
            pst = connection.prepareStatement("SELECT * FROM " + this.tableName);
            rs = pst.executeQuery();
            while (rs.next()) {
                Parent parent = parentDAO.getById(rs.getInt("NumPar"));
                children.add(new Child(rs.getInt("NumChild"), rs.getString("ChildLastName"),
                        rs.getString("ChildFirstName"), rs.getInt("ChildAge"), parent));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return children;
    }

//    public void AfficherEnfant()
//    {
//        try {
//            st = dbc.getConnection().createStatement();
//            ResultSet rst = st.executeQuery("SELECT * FROM Child");
//
//            while(rst.next()) {
//                System.out.println("Enfant N°: " + rst.getInt("numChild") + " Prénom: " +
//                        rst.getString("childFirstName") + " Nom:  " +
//                        rst.getString("childLastName")  + "Age: "
//                        + rst.getString("childAge")+ "\n" + rst.getString("parent"));
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Erreur" + e.getMessage());
//        }

}
