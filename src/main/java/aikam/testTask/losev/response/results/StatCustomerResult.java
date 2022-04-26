package aikam.testTask.losev.response.results;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StatCustomerResult extends Result {
    private String name;
    private List<CustomerPurchase> purchases;
    private BigDecimal totalExpenses;

    public StatCustomerResult(String name) {
        this.name = name;
        this.purchases = new ArrayList<>();
        this.totalExpenses = BigDecimal.ZERO;
    }

    public void addPurchase(CustomerPurchase customerPurchase) {
        for (CustomerPurchase cp : purchases) {
            if (cp.getName().equals(customerPurchase.getName())) {
                cp.setExpenses(cp.getExpenses().add(customerPurchase.getExpenses()));
                totalExpenses = totalExpenses.add(customerPurchase.getExpenses());
                return;
            }
        }
        purchases.add(customerPurchase);
        totalExpenses = totalExpenses.add(customerPurchase.getExpenses());
    }

    public void sortPurchases() {
        purchases = purchases.stream().sorted((p1, p2) ->  p2.getExpenses().intValue()- p1.getExpenses().intValue()).collect(Collectors.toList());
    }
}
