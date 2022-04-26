package aikam.testTask.losev.response;

import aikam.testTask.losev.response.results.StatCustomerResult;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StatResponse {
    private final String type = "stat";
    private int totalDays;
    private List<StatCustomerResult> customers;
    private BigDecimal totalExpenses;
    private BigDecimal avgExpenses;

    public StatResponse() {
        this.customers = new ArrayList<>();
        this.totalExpenses = BigDecimal.ZERO;
        this.avgExpenses = BigDecimal.ZERO;
    }

    public void addResult(StatCustomerResult statCustomerResult) {
        customers.add(statCustomerResult);
        if (totalExpenses.equals(BigDecimal.ZERO)) {
            totalExpenses = statCustomerResult.getTotalExpenses();
        } else {
            totalExpenses = totalExpenses.add(statCustomerResult.getTotalExpenses());
        }
        avgExpenses = totalExpenses.divide(BigDecimal.valueOf(customers.size()), 2);
    }


    public void calculateTotalDays(LocalDate startDate, LocalDate endDate) {
        int weekDays = 0;
        while (startDate.isBefore(endDate)) {
            if (startDate.getDayOfWeek().getValue() != 6 && startDate.getDayOfWeek().getValue() != 7) {
                weekDays++;
            }
            startDate = startDate.plusDays(1);
        }
        if (endDate.getDayOfWeek().getValue() != 6 && endDate.getDayOfWeek().getValue() != 7) {
            weekDays++;
        }
        totalDays = weekDays;
    }

    public void sortCustomers() {
        customers = customers.stream().sorted((c1, c2) ->  c2.getTotalExpenses().intValue()- c1.getTotalExpenses().intValue()).collect(Collectors.toList());
    }
}
