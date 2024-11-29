package com.gestiongarderiewebapp.servlet;

import com.gestiongarderiewebapp.bean.Child;
import com.gestiongarderiewebapp.bean.Educator;
import com.gestiongarderiewebapp.bean.Employee;
import com.gestiongarderiewebapp.bean.Inscription;
import com.gestiongarderiewebapp.dao.EducatorDAO;
import com.gestiongarderiewebapp.dao.EmployeeDAO;
import com.gestiongarderiewebapp.dao.InscriptionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/makeInscri", "/deleteInscri", "/voirInscri"})
public class InscriptionServlet extends HttpServlet {
    InscriptionDAO insDAO = new InscriptionDAO();
    ArrayList<Inscription> inscriptions = new ArrayList<>();
    Inscription insc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        switch (url) {
            case "/voirInscri":
                inscriptions = insDAO.getAllInscriptions();
                req.setAttribute("inscriptions", inscriptions);
                this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(req,resp);
                break;
            case "/deleteInscri":
                insc = insDAO.getInscriptionByIds(Integer.parseInt(req.getParameter("numEmp")),
                        Integer.parseInt(req.getParameter("numChild")));
                insDAO.deleteInscription(insc);
                resp.sendRedirect("voirInscri");
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/makeInscri")) {
            Employee emp = insDAO.getEmployeeDAO().getById(
                    Integer.parseInt(req.getParameter("numEmp")));
            Child child = insDAO.getChildDAO().getChildById(
                    Integer.parseInt(req.getParameter("numChild")));
            try {
                insc = new Inscription(child, emp);
                insDAO.createInscription(insc);
            } catch (NullPointerException e) {
                System.err.println("Erreur, L'employé ou l'enfant est introuvale. " + e.getMessage());
            }
            this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(req,resp);
        }
    }
}
