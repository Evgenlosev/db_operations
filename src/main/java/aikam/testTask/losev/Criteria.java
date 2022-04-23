package aikam.testTask.losev;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
//    private CriteriaLastName criteriaLastName;
//    private CriteriaProduct criteriaProduct;
//    private CriteriaExpenses criteriaExpenses;
//    private CriteriaBadCustomers criteriaBadCustomers;
    private String lastName;
    private String productName;
    private int minTimes;
    private BigDecimal minExpenses;
    private BigDecimal maxExpenses;
    private int badCustomers;
}
