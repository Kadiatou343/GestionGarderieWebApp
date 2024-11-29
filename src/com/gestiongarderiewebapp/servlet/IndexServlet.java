package com.gestiongarderiewebapp.servlet;

import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.dao.ChildDAO;
import com.gestiongarderiewebapp.dao.EmployeeDAO;
import com.gestiongarderiewebapp.util.PasswordHasher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet({"/index", "/home", "/login"})
public class IndexServlet extends HttpServlet {
    ChildDAO childDAO = new ChildDAO();
    int count = childDAO.getChildrenCount();
    EmployeeDAO empDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        switch (url) {
            case "/home":
                this.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
                break;
            case "/index":
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/login")) {
            Employee emp = empDAO.getById(Integer.parseInt(req.getParameter("numEmp")));
            try {
                if (PasswordHasher.validatePassword(req.getParameter("password"), emp.getPasswordHash())) {
                    req.setAttribute("employee", emp);
                    req.setAttribute("count", count);
                    this.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Le mot de passe est incorrect");
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            } catch (NullPointerException e) {
                req.setAttribute("message", "Le num employé n'est pas valide");
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            } catch (NoSuchAlgorithmException e) {
                System.err.println("Erreur lors de la validation du mot de passe. " + e.getMessage());
            }
        }
    }
}
