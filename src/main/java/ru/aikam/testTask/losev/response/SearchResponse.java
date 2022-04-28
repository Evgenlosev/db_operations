package ru.aikam.testTask.losev.response;

import ru.aikam.testTask.losev.dto.CustomerDto;
import ru.aikam.testTask.losev.request.criterias.ExpensesCriteria;
import ru.aikam.testTask.losev.response.results.Result;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class SearchResponse {
    private final String type = "search";
    private List<Result> results;

    public SearchResponse() {
        this.results = new ArrayList<>();
    }

    @Data
    public static class ResultExpenses extends Result {
        private ExpensesCriteria expensesCriteria;
        private List<CustomerDto> results;

        public ResultExpenses(ExpensesCriteria expensesCriteria) {
            this.expensesCriteria = expensesCriteria;
            this.results = new ArrayList<>();
        }

    }
}
