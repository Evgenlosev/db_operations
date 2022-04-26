package aikam.testTask.losev.dao;

import aikam.testTask.losev.SessionFactoryUtils;
import aikam.testTask.losev.converters.CustomerConverter;
import aikam.testTask.losev.dto.CustomerDto;
import aikam.testTask.losev.entities.Customer;
import aikam.testTask.losev.exceptions.ApplicationException;
import aikam.testTask.losev.request.criterias.BadCustomersCriteria;
import aikam.testTask.losev.request.criterias.ExpensesCriteria;
import aikam.testTask.losev.request.criterias.LastNameCriteria;
import aikam.testTask.losev.request.criterias.ProductCriteria;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDao {
    private SessionFactoryUtils sessionFactoryUtils;
    private CustomerConverter customerConverter;

    public CustomerDao(SessionFactoryUtils sessionFactoryUtils, CustomerConverter customerConverter) {
        this.sessionFactoryUtils = sessionFactoryUtils;
        this.customerConverter = customerConverter;
    }

    public List<CustomerDto> findByCriteria (LastNameCriteria lastNameCriteria) throws ApplicationException {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select c from Customer c where c.lastName = :lastName")
                    .setParameter("lastName", lastNameCriteria.getLastName())
                    .getResultList();
            List<CustomerDto> results = customers.stream().map(c -> customerConverter.entityToDto(c)).collect(Collectors.toList());
            session.getTransaction().commit();
            return results;
        }
    }

    public List<CustomerDto> findByCriteria (ProductCriteria productCriteria) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createNativeQuery(
                    "select c.id, c.first_name, c.last_name, prod.title, count(prod.title) from customers c " +
                            "left join purchases p on c.id = p.customer_id " +
                            "left join products prod on p.product_id = prod.id " +
                            "where prod.title = :productName " +
                            "group by c.id, prod.title " +
                            "having count(prod.title) >= :minTimes ;")
                    .setParameter("productName", productCriteria.getProductName())
                    .setParameter("minTimes", productCriteria.getMinTimes())
                    .addEntity(Customer.class).list();
            List<CustomerDto> results = customers.stream().map(c -> customerConverter.entityToDto(c)).collect(Collectors.toList());
            return results;
        }
    }

    public List<CustomerDto> findByCriteria (ExpensesCriteria expensesCriteria) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createNativeQuery(
                    "select c.id, c.first_name, c.last_name from customers c " +
                            "left join purchases p on c.id = p.customer_id " +
                            "group by c.id " +
                            "having sum(p.price) >= :minExpenses and sum(p.price) <= :maxExpenses ;")
                    .setParameter("minExpenses", expensesCriteria.getMinExpenses())
                    .setParameter("maxExpenses", expensesCriteria.getMaxExpenses())
                    .addEntity(Customer.class).list();
            List<CustomerDto> results = customers.stream().map(c -> customerConverter.entityToDto(c)).collect(Collectors.toList());
            return results;
        }
    }

    public List<CustomerDto> findByCriteria (BadCustomersCriteria badCustomersCriteria) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createNativeQuery(
                    "select c.id, c.first_name, c.last_name, count(c.id) from customers c " +
                            "left join purchases p on c.id = p.customer_id " +
                            "group by c.id " +
                            "order by count(c.id) " +
                            "limit :badCustomers ;")
                    .setParameter("badCustomers", badCustomersCriteria.getBadCustomers())
                    .addEntity(Customer.class).list();
            List<CustomerDto> results = customers.stream().map(c -> customerConverter.entityToDto(c)).collect(Collectors.toList());
            return results;
        }
    }
}
