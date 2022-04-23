package aikam.testTask.losev.serviсes;

import aikam.testTask.losev.SearchRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class RequestHandler {

    public static void searchRequestHandling (String input, String output) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SearchRequest searchRequest = objectMapper.readValue(new File(input), SearchRequest.class);
            System.out.println(searchRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
