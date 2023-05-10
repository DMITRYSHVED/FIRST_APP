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

@WebServlet("/cityAdd")
public class AddCityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", DAO.getEntity(new Student()));
        req.setAttribute("grooups",DAO.getEntity(new Grooup()));
        req.setAttribute("cities",DAO.getEntity(new City()));
        req.setAttribute("error",req.getParameter("error"));
        getServletContext().getRequestDispatcher("/WEB-INF/addCity.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!DAO.validate(req.getParameter("name"))) {
            resp.sendRedirect("/cityAdd?error=INVALID NAME FORMAT");
            return;
        }
        City city = new City();
        city.setName(req.getParameter("name"));
        try {
            DAO.addCity(city);
            resp.sendRedirect("/home");
        }catch (ConstraintViolationException e){
            resp.sendRedirect("/cityAdd?error=THIS CITY ALREADY EXISTS");
        }
    }
}
