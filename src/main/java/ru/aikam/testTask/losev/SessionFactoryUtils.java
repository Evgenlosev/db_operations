package ru.aikam.testTask.losev;

import ru.aikam.testTask.losev.exceptions.ApplicationException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryUtils {
    private SessionFactory factory;

    public void init() throws ApplicationException {
        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
//                .configure("hibernate.properties")
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new ApplicationException("Не удалось подключиться к базе данных");
        }

    }

    public Session getSession () {
        return factory.getCurrentSession();
    }

    public void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
