package aikam.testTask.losev.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatRequest {
    private String startDate;
    private String endDate;

}
