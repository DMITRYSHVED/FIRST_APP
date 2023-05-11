package servlets;

import entities.City;
import entities.Grooup;
import entities.Student;
import hibernate_util.FactoryManager;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cityUpdate")
public class UpdateCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", DAO.getEntity(new Student()));
        req.setAttribute("grooups", DAO.getEntity(new Grooup()));
        req.setAttribute("cities", DAO.getEntity(new City()));
        req.getServletContext().getRequestDispatcher("/WEB-INF/updateCity.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = FactoryManager.getSessionFactory().openSession();
        City city = session.get(City.class, Long.parseLong(req.getParameter("id")));
        if (!req.getParameter("name").isEmpty()) {
            city.setName(req.getParameter("name"));
        }
        DAO.updateCity(session, city);
        resp.sendRedirect("/home");
    }
}
