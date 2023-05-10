package servlets;

import entities.City;
import entities.Grooup;
import entities.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupDelete")
public class deleteGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", DAO.getEntity(new Student()));
        req.setAttribute("grooups", DAO.getEntity(new Grooup()));
        req.setAttribute("cities", DAO.getEntity(new City()));
        getServletContext().getRequestDispatcher("/WEB-INF/deleteGroup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO.deleteGroup(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/home");
    }
}
