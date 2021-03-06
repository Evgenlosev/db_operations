package ru.aikam.testTask.losev.response.results;

import ru.aikam.testTask.losev.dto.CustomerDto;
import ru.aikam.testTask.losev.request.criterias.ProductCriteria;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductResult extends Result {
    private ProductCriteria productCriteria;
    private List<CustomerDto> results;

    public ProductResult(ProductCriteria productCriteria) {
        this.productCriteria = productCriteria;
        this.results = new ArrayList<>();
    }

}
