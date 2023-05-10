package servlets;

import entities.City;
import entities.Grooup;
import entities.MyEntity;
import entities.Student;
import hibernate_util.FactoryManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import static hibernate_util.FactoryManager.getSessionFactory;

public class DAO {

    protected static void addStudent(Student student) {
        Session session = getSessionFactory().openSession();
        Transaction writeTransaction = session.beginTransaction();
        session.save(student);
        writeTransaction.commit();
        session.close();
    }

    protected static void deleteStudent(long studentId) {
        Session session = getSessionFactory().openSession();
        Transaction deleteTransaction = session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        session.delete(student);
        deleteTransaction.commit();
        session.close();
    }

    protected static void addGroup(Grooup grooup) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(grooup);
        transaction.commit();
        session.close();
    }

    protected static void addCity(City city) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }

    protected static void deleteCity(long cityId) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        City city = session.get(City.class, cityId);
        session.delete(city);
        transaction.commit();
        session.close();
    }

    protected static void deleteGroup(long groupId) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Grooup grooup = session.get(Grooup.class, groupId);
        session.delete(grooup);
        transaction.commit();
        session.close();
    }

    protected static void updateStudent(Session session, Student student) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        transaction.commit();
        session.close();
    }

    protected static void updateGroup(Session session, Grooup grooup) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(grooup);
        transaction.commit();
        session.close();
    }

    protected static void updateCity(Session session, City city) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(city);
        transaction.commit();
        session.close();
    }

    protected static List findStudent(String criteria) {
        Session session = FactoryManager.getSessionFactory().openSession();
        List<Student> students = session.createQuery("FROM Student ").list();
        List<Student> resultStudents = new ArrayList<>();

        for (Student student : students) {
            if (criteria.equals(String.valueOf(student.getId()))) {
                resultStudents.add(student);
            }
            if (criteria.equals(student.getName())) {
                resultStudents.add(student);
            }
            if (criteria.equals(student.getSurname())) {
                resultStudents.add(student);
            }
            if (criteria.equals(String.valueOf(student.getAge()))) {
                resultStudents.add(student);
            }
            if (criteria.equals(student.getGrooup().getTitle())) {
                resultStudents.add(student);
            }
            if (criteria.equals(student.getCity().getName())) {
                resultStudents.add(student);
            }
        }
        session.close();
        return resultStudents;
    }

    protected static List<City> findCity(String criteria) {
        Session session = FactoryManager.getSessionFactory().openSession();
        List<City> cities = session.createQuery("FROM City ").list();
        List<City> resultCities = new ArrayList<>();

        for (City city : cities) {
            if (criteria.equals(String.valueOf(city.getId()))) {
                resultCities.add(city);
            }
            if (criteria.equals(city.getName())) {
                resultCities.add(city);
            }
        }
        session.close();
        return resultCities;
    }

    protected static List<Grooup> findGroup(String criteria) {
        Session session = FactoryManager.getSessionFactory().openSession();
        List<Grooup> grooups = session.createQuery("FROM Grooup ").list();
        List<Grooup> resultGroups = new ArrayList<>();

        for (Grooup grooup : grooups) {
            if (criteria.equals(String.valueOf(grooup.getId()))) {
                resultGroups.add(grooup);
            }
            if (criteria.equals(grooup.getTitle())) {
                resultGroups.add(grooup);
            }
        }
        session.close();
        return resultGroups;
    }

    protected static List<MyEntity> getEntity(Object o) {
        if (o instanceof Student) {
            List<MyEntity> students;
            Session session = getSessionFactory().openSession();
            students = session.createQuery("FROM Student ").list();
            session.close();
            return students;
        } else if (o instanceof Grooup) {
            List<MyEntity> grooups;
            Session session = getSessionFactory().openSession();
            grooups = session.createQuery("FROM Grooup ").list();
            session.close();
            return grooups;
        } else if (o instanceof City) {
            List<MyEntity> cities;
            Session session = getSessionFactory().openSession();
            cities = session.createQuery("FROM City ").list();
            return cities;
        } else {
            return null;
        }
    }

    protected static boolean validate(String param) {
        return param != null && !param.isEmpty();
    }
}
