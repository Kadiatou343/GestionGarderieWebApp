package com.gestiongarderiewebapp.servlet;

import com.gestiongarderiewebapp.bean.Parent;
import com.gestiongarderiewebapp.dao.ParentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"parents", "deleteParent"})
public class ParentServlet extends HttpServlet {
    ParentDAO parentDAO = new ParentDAO();
    ArrayList<Parent> parents = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        if (url.equals("parents")){
            parents = parentDAO.getAllParents();
            req.setAttribute("parents", parents);
            this.getServletContext().getRequestDispatcher("/parent.jsp").forward(req, resp);
        } else if (url.equals("deleteParent")){
            Parent par = parentDAO.getParentById(Integer.parseInt(req.getParameter("numPar")));
            parentDAO.delete(par);
            resp.sendRedirect("parents");
        }
    }
}
