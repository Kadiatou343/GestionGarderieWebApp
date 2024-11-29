package com.gestiongarderiewebapp.servlet;

import com.gestiongarderiewebapp.bean.Inscription;
import com.gestiongarderiewebapp.dao.InscriptionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/makeInscri","/deleteInscri","/voirInscri"})
public class InscriptionServlet extends HttpServlet{
    InscriptionDAO insDao = new InscriptionDAO();
    Inscription insc;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        switch (url){
            case "/voirInscri":
                break;
            case "/deleteInscri":
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
