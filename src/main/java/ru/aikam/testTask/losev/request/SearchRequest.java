package ru.aikam.testTask.losev.request;

import ru.aikam.testTask.losev.request.criterias.Criteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private List<Criteria> criterias;

}
