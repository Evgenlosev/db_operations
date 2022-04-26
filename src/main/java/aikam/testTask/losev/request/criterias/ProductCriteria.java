package aikam.testTask.losev.request.criterias;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCriteria {
    private String productName;
    private int minTimes;
}
