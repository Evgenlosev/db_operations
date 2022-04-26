package aikam.testTask.losev;

import aikam.testTask.losev.converters.CustomerConverter;
import aikam.testTask.losev.dao.CustomerDao;
import aikam.testTask.losev.dao.PurchaseDao;
import aikam.testTask.losev.entities.Customer;
import aikam.testTask.losev.entities.Purchase;
import aikam.testTask.losev.exceptions.ApplicationException;
import aikam.testTask.losev.request.SearchRequest;
import aikam.testTask.losev.request.StatRequest;
import aikam.testTask.losev.request.criterias.*;
import aikam.testTask.losev.response.SearchResponse;
import aikam.testTask.losev.response.StatResponse;
import aikam.testTask.losev.response.results.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RequestHandler {
    private static SessionFactoryUtils sessionFactoryUtils;

    private static void init() throws ApplicationException {
        sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
    }

    public static SearchResponse requestHandling (SearchRequest searchRequest) throws ApplicationException {
        try {
            // Создаем SessionFactory
            init();
            CustomerConverter customerConverter = new CustomerConverter();
            //Создаем класс для доступа к базе данных
            CustomerDao customerDao = new CustomerDao(sessionFactoryUtils, customerConverter);
            //Создаем пустой объект Response
            SearchResponse searchResponse = new SearchResponse();
            //Для каждого критерия определяем его вид, формируем соответствующий результат и добавляем к ответу
            for (Criteria criteria : searchRequest.getCriterias()) {
                if (criteria.getLastName() != null) {
                    LastNameCriteria lastNameCriteria = new LastNameCriteria(criteria.getLastName());
                    LastNameResult lastNameResult = new LastNameResult(lastNameCriteria);
                    lastNameResult.setResults(customerDao.findByCriteria(lastNameCriteria));
                    searchResponse.getResults().add(lastNameResult);
                }
                if (criteria.getProductName() != null) {
                    ProductCriteria productCriteria = new ProductCriteria(criteria.getProductName(), criteria.getMinTimes());
                    ProductResult productResult = new ProductResult(productCriteria);
                    productResult.setResults(customerDao.findByCriteria(productCriteria));
                    searchResponse.getResults().add(productResult);
                }
                if (criteria.getMinExpenses() != null) {
                    ExpensesCriteria expensesCriteria = new ExpensesCriteria(criteria.getMinExpenses(), criteria.getMaxExpenses());
                    SearchResponse.ResultExpenses resultExpenses = new SearchResponse.ResultExpenses(expensesCriteria);
                    resultExpenses.setResults(customerDao.findByCriteria(expensesCriteria));
                    searchResponse.getResults().add(resultExpenses);
                }
                if (criteria.getBadCustomers() != 0) {
                    BadCustomersCriteria badCustomersCriteria = new BadCustomersCriteria(criteria.getBadCustomers());
                    BadCustomersResult badCustomersResult = new BadCustomersResult(badCustomersCriteria);
                    badCustomersResult.setResults(customerDao.findByCriteria(badCustomersCriteria));
                    searchResponse.getResults().add(badCustomersResult);
                }
            }
            return searchResponse;
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }

    public static StatResponse requestHandling (StatRequest statRequest) throws ApplicationException {
        try {
            init();
            StatResponse statResponse = new StatResponse();
            LocalDate startDate = LocalDate.parse(statRequest.getStartDate());
            LocalDate endDate = LocalDate.parse(statRequest.getEndDate());
            statResponse.calculateTotalDays(startDate, endDate);
            //получаем список всех покупок за период и исключаем выходные;
            PurchaseDao purchaseDao = new PurchaseDao(sessionFactoryUtils);
            List<Purchase> purchases =  purchaseDao.getPurchasesForPeriod(startDate, endDate)
                    .stream()
                    .filter(p1 -> p1.getDate().getDayOfWeek().getValue() != 6 && p1.getDate().getDayOfWeek().getValue() != 7)
                    .collect(Collectors.toList());
            //получаем список уникальных покупателей за этот период
            List<Customer> customers = new ArrayList<>();
            for (Purchase purchase : purchases) {
                if (!customers.contains(purchase.getCustomer())) {
                    customers.add(purchase.getCustomer());
                }
            }
            //Для каждого уникального покупателя сформируем список его покупок уникальных товаров
            for (Customer customer : customers) {
                StatCustomerResult statCustomerResult = new StatCustomerResult(customer.getLastName() + " " + customer.getFirstName());
                for (Purchase purchase : purchases) {
                    if (purchase.getCustomer().equals(customer)) {
                        CustomerPurchase customerPurchase = new CustomerPurchase(purchase.getProduct().getTitle(), purchase.getProduct().getPrice());
                        statCustomerResult.addPurchase(customerPurchase);
                    }
                }
                statCustomerResult.sortPurchases();
                statResponse.addResult(statCustomerResult);
                statResponse.sortCustomers();

            }
            return statResponse;
        } catch (DateTimeParseException e) {
            throw new ApplicationException("Неправильный формат даты в входном файле");
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
