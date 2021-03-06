package ru.aikam.testTask.losev.dao;

import ru.aikam.testTask.losev.SessionFactoryUtils;
import ru.aikam.testTask.losev.entities.Purchase;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class PurchaseDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public PurchaseDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public List<Purchase> getPurchasesForPeriod(LocalDate startDate, LocalDate endDate) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Purchase> purchases = session.createQuery("select p from Purchase p where p.date between :starDate and :endDate ")
                    .setParameter("starDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();
            session.getTransaction().commit();
            return purchases;
        }
    }

}
