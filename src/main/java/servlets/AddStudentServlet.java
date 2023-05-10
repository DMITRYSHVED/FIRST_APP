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

@WebServlet("/studentAdd")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", DAO.getEntity(new Student()));
        req.setAttribute("grooups", DAO.getEntity(new Grooup()));
        req.setAttribute("cities", DAO.getEntity(new City()));
        req.setAttribute("error", req.getParameter("error"));
        getServletContext().getRequestDispatcher("/WEB-INF/addStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!DAO.validate(req.getParameter("name"))) {
            resp.sendRedirect("/studentAdd?error=INVALID FORMAT");
            return;
        }
        if (!DAO.validate(req.getParameter("surname"))) {
            resp.sendRedirect("/studentAdd?error=INVALID FORMAT");
            return;
        }
        if (!DAO.validate(req.getParameter("age"))) {
            resp.sendRedirect("/studentAdd?error=INVALID FORMAT");
            return;
        }
        if (!DAO.validate(req.getParameter("city"))) {
            resp.sendRedirect("/studentAdd?error=INVALID NAME FORMAT");
            return;
        }
        if (!DAO.validate(req.getParameter("group"))) {
            resp.sendRedirect("/studentAdd?error=INVALID NAME FORMAT");
            return;
        }
        Session session = FactoryManager.getSessionFactory().openSession();
        Student student = new Student();
        City city = session.get(City.class, Long.parseLong(req.getParameter("city")));
        Grooup grooup = session.get(Grooup.class, Long.parseLong(req.getParameter("group")));
        student.setName(req.getParameter("name"));
        student.setSurname(req.getParameter("surname"));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        student.setCity(city);
        student.setGrooup(grooup);
        DAO.addStudent(student);
        resp.sendRedirect("/home");
    }
}
