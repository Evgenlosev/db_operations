package aikam.testTask.losev;

import org.hibernate.Session;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class TestClass {

//    public static void main(String[] args) {
//        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
//        sessionFactoryUtils.init();
//
//        LocalDate startDate = LocalDate.of(2021, 05, 1); //start date
//        long start = startDate.toEpochDay();
//
//        LocalDate endDate = LocalDate.now(); //end date
//        long end = endDate.toEpochDay();
//
//
//
//
//        for (int i = 200; i < 301; i++) {
//            int cus = 1 + (int) (Math.random() * 30);
//            int prod = 1 + (int) (Math.random() * 22);
//
//            long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
//            LocalDate date = LocalDate.ofEpochDay(randomEpochDay); // random date between the range
//
//            Session session = sessionFactoryUtils.getSession();
//            session.beginTransaction();
//
//            session.createNativeQuery("insert into purchases (id, customer_id, product_id, date) " +
//                    "values ( :id , :cus , :prod , :date )")
//                            .setParameter("id", i)
//                            .setParameter("cus", cus)
//                            .setParameter("prod", prod)
//                            .setParameter("date", date).executeUpdate();
//
//            session.getTransaction().commit();
//
//        }
//    }


}
