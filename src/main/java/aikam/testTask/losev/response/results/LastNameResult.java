package aikam.testTask.losev.response.results;

import aikam.testTask.losev.dto.CustomerDto;
import aikam.testTask.losev.request.criterias.LastNameCriteria;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LastNameResult extends Result {
    private LastNameCriteria lastNameCriteria;
    private List<CustomerDto> results;

    public LastNameResult(LastNameCriteria lastNameCriteria) {
        this.lastNameCriteria = lastNameCriteria;
        this.results = new ArrayList<>();
    }


}
