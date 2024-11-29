package com.gestiongarderiewebapp.servlet;

import com.gestiongarderiewebapp.bean.Child;
import com.gestiongarderiewebapp.bean.Parent;
import com.gestiongarderiewebapp.dao.ChildDAO;
import com.gestiongarderiewebapp.dao.ParentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/children","/addChild", "/editChild", "/updateChild", "/deleteChild"})
public class ChildServlet extends HttpServlet {
    ChildDAO childDAO = new ChildDAO();
    ParentDAO parentDAO = new ParentDAO();
    ArrayList<Child> children = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        Child child;
        switch (url){
            case "/children":
                children = childDAO.getAllChildren();
                req.setAttribute("children", children);
                this.getServletContext().getRequestDispatcher("/child.jsp").forward(req, resp);
                break;
            case "/editChild":
                child = childDAO.getChildById(Integer.parseInt(req.getParameter("numChild")));
                req.setAttribute("child", child);
                this.getServletContext().getRequestDispatcher("/addChild.jsp").forward(req,resp);
                break;
            case "/deleteChild":
                child = childDAO.getChildById(Integer.parseInt(req.getParameter("numChild")));
                childDAO.delete(child);
                resp.sendRedirect("children");
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();
        Parent par;
        Child child;
        switch (url){
            case "/addChild":
                par = new Parent(Integer.parseInt(req.getParameter("numPar")), req.getParameter("lastNameP"),
                        req.getParameter("firstNameP"), req.getParameter("contact"));
                parentDAO.create(par);
                child = new Child(req.getParameter("lastNameE"), req.getParameter("firstNameE"),
                        Integer.parseInt(req.getParameter("age")), par);

                childDAO.createChild(child);

                this.getServletContext().getRequestDispatcher("addChild.jsp").forward(req, resp);

                break;
            case "/updateChild":
                par = new Parent(Integer.parseInt(req.getParameter("numParHidden")),
                        req.getParameter("lastNameP"), req.getParameter("firstNameP"),
                        req.getParameter("contact"));
                parentDAO.update(par);
                child = new Child(Integer.parseInt(req.getParameter("numChild")),
                        req.getParameter("lastNameE"), req.getParameter("firstNameE"),
                        Integer.parseInt(req.getParameter("age")), par);
                childDAO.update(child);

                resp.sendRedirect("children");
            default:
        }
    }
}
