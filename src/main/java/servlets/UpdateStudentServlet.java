package servlets;

import entities.City;
import entities.Grooup;
import entities.Student;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static hibernate_util.FactoryManager.getSessionFactory;

@WebServlet("/studentUpdate")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", DAO.getEntity(new Student()));
        req.setAttribute("grooups", DAO.getEntity(new Grooup()));
        req.setAttribute("cities", DAO.getEntity(new City()));
        getServletContext().getRequestDispatcher("/WEB-INF/updateStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = getSessionFactory().openSession();
        Student student = session.get(Student.class, Long.parseLong(req.getParameter("id")));
        if (!req.getParameter("name").isEmpty()) {
            student.setName(req.getParameter("name"));
        }
        if (!req.getParameter("surname").isEmpty()) {
            student.setSurname(req.getParameter("surname"));
        }
        if (!req.getParameter("age").isEmpty() && req.getParameter("age") != null) {
            student.setAge(Integer.parseInt(req.getParameter("age")));
        }
        if (!req.getParameter("group").isEmpty()) {
            student.getGrooup().setTitle(req.getParameter("group"));
        }
        if (!req.getParameter("city").isEmpty()) {
            student.getCity().setName(req.getParameter("city"));
        }
        DAO.updateStudent(session, student);
        resp.sendRedirect("/home");
    }
}
