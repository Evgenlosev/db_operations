package ru.aikam.testTask.losev.response.results;

import ru.aikam.testTask.losev.dto.CustomerDto;
import ru.aikam.testTask.losev.request.criterias.BadCustomersCriteria;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BadCustomersResult extends Result {
    private BadCustomersCriteria badCustomersCriteria;
    private List<CustomerDto> results;

    public BadCustomersResult(BadCustomersCriteria badCustomersCriteria) {
        this.badCustomersCriteria = badCustomersCriteria;
        this.results = new ArrayList<>();
    }

}
