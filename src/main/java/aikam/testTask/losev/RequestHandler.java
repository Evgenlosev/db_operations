package aikam.testTask.losev;

import aikam.testTask.losev.SearchRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class RequestHandler {

    public static void requestHandling (SearchRequest searchRequest) {
        SearchResponse searchResponse = new SearchResponse();
        for (Criteria criteria : searchRequest.getCriterias()) {
            if (criteria.getLastName() != null) {

            }
        }
    }



}
