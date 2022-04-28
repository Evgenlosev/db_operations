package ru.aikam.testTask.losev.request.criterias;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
    private String lastName;
    private String productName;
    private int minTimes;
    private BigDecimal minExpenses;
    private BigDecimal maxExpenses;
    private int badCustomers;
}
