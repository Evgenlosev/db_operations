package aikam.testTask.losev.converters;

import aikam.testTask.losev.dto.CustomerDto;
import aikam.testTask.losev.entities.Customer;

public class CustomerConverter {
    public CustomerDto entityToDto (Customer customer) {
        return new CustomerDto(customer.getLastName(), customer.getFirstName());
    }
}
