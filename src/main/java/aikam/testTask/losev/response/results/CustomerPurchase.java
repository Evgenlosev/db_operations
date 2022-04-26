package aikam.testTask.losev.response.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPurchase {
    private String name;
    private BigDecimal expenses;

}
