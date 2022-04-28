package ru.aikam.testTask.losev.converters;

import ru.aikam.testTask.losev.dto.CustomerDto;
import ru.aikam.testTask.losev.entities.Customer;

public class CustomerConverter {
    public CustomerDto entityToDto (Customer customer) {
        return new CustomerDto(customer.getLastName(), customer.getFirstName());
    }
}
