package hibernate_util;

import entities.City;
import entities.Grooup;
import entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FactoryManager {

    private static volatile FactoryManager instance;
    private static SessionFactory sessionFactory;

    private FactoryManager() {
    }

    public static SessionFactory getSessionFactory() {

        if (instance != null) {
            return sessionFactory;
        }
        synchronized (FactoryManager.class) {
            Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Grooup.class);
            configuration.addAnnotatedClass(City.class);
            configuration.configure();
            StandardServiceRegistry registryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(registryBuilder);
            instance = new FactoryManager();
        }
        return sessionFactory;
    }
}
