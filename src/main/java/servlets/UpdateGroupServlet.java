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

@WebServlet("/groupUpdate")
public class UpdateGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", DAO.getEntity(new Student()));
        req.setAttribute("grooups", DAO.getEntity(new Grooup()));
        req.setAttribute("cities", DAO.getEntity(new City()));
        getServletContext().getRequestDispatcher("/WEB-INF/updateGroup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = FactoryManager.getSessionFactory().openSession();
        Grooup grooup = session.get(Grooup.class, Long.parseLong(req.getParameter("id")));
        if (!req.getParameter("title").isEmpty()) {
            grooup.setTitle(req.getParameter("title"));
        }
        DAO.updateGroup(session, grooup);
        resp.sendRedirect("/home");
    }
}
