package aikam.testTask.losev;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class MainApp {

    public static void main(String[] args) throws IOException {

        String commandType = "search";
        String inputPath = "C:/input.json";
        String outputPath = "C:/output.json";

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            throw new RuntimeException("Не найден файл " + inputPath);
        }

        if (commandType.toLowerCase().equals("search")) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                SearchRequest searchRequest = objectMapper.readValue(inputFile, SearchRequest.class);
                System.out.println(searchRequest);
                RequestHandler.requestHandling(searchRequest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (commandType.toLowerCase().equals("stat")) {

        } else {
            throw new RuntimeException("Неверный формат команды");
        }

    }
}
