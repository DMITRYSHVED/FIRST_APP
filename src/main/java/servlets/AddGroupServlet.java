package servlets;

import entities.City;
import entities.Grooup;
import entities.Student;
import org.hibernate.exception.ConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupAdd")
public class AddGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", DAO.getEntity(new Student()));
        req.setAttribute("grooups", DAO.getEntity(new Grooup()));
        req.setAttribute("cities", DAO.getEntity(new City()));
        req.setAttribute("error", req.getParameter("error"));
        getServletContext().getRequestDispatcher("/WEB-INF/addGroup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!DAO.validate(req.getParameter("title"))) {
            resp.sendRedirect("/groupAdd?error=INVALID TITLE FORMAT");
            return;
        }
        Grooup grooup = new Grooup();
        grooup.setTitle(req.getParameter("title"));
        try {
            DAO.addGroup(grooup);
            resp.sendRedirect("/home");
        } catch (ConstraintViolationException e) {
            resp.sendRedirect("/groupAdd?error=THIS GROUP ALREADY EXISTS");
        }
    }
}
