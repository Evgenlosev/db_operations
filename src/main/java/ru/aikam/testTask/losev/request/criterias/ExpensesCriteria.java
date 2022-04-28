package ru.aikam.testTask.losev.request.criterias;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ExpensesCriteria {
    private BigDecimal minExpenses;
    private BigDecimal maxExpenses;
}
