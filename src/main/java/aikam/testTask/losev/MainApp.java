package aikam.testTask.losev;

import aikam.testTask.losev.exceptions.ApplicationError;
import aikam.testTask.losev.exceptions.ApplicationException;
import aikam.testTask.losev.request.SearchRequest;
import aikam.testTask.losev.request.StatRequest;
import aikam.testTask.losev.response.SearchResponse;
import aikam.testTask.losev.response.StatResponse;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;


import java.io.File;

@Slf4j
public class MainApp {

    public static ObjectMapper objectMapper;
    public static void main(String[] args) throws Exception {

        try {
            start(args);
        } catch (ApplicationException e) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(args[2]), new ApplicationError(e.getMessage()));
        }
    }

    private static void start(String[] args) throws ApplicationException {
        if (args.length != 3) {
            log.error("Неверный формат ввода команды");
            System.exit(1);
        }

        File outputFile = new File(args[2]);
        if (!outputFile.canWrite()) {
            log.error("Ошибка доступа к выходному файлу");
            System.exit(1);
        }

        if (!args[0].equalsIgnoreCase("stat") && !args[0].equalsIgnoreCase("search")) {
            throw new ApplicationException("Неверный формат ввода команды");
        }

        File inputFile = new File(args[1]);
        if (!inputFile.exists()) {
            throw new ApplicationException("Не найден входной файл");
        }
        if (!inputFile.canRead()) {
            throw new ApplicationException("Ошибка доступа к входному файлу");
        }

        String commandType = args[0];
        objectMapper = new ObjectMapper();

        switch (commandType) {
            case ("search"):
                SearchRequest searchRequest = parseJsonToObject(inputFile, SearchRequest.class);
                SearchResponse searchResponse = RequestHandler.requestHandling(searchRequest);
                parseObjectToJson(outputFile, searchResponse);
                break;
            case ("stat"):
                StatRequest statRequest = parseJsonToObject(inputFile, StatRequest.class);
                StatResponse statResponse = RequestHandler.requestHandling(statRequest);
                parseObjectToJson(outputFile, statResponse);
                break;
        }
    }

    private static void parseObjectToJson(File outputFile, Object object) {
        try {
            objectMapper.writeValue(outputFile, object);
        } catch (Exception e) {
            log.error("Ошибка доступа к выходному файлу");
            System.exit(1);
        }
    }

    private static <T> T parseJsonToObject(File src, Class<T> valueType) throws ApplicationException {
        try {
            T object = objectMapper.readValue(src, valueType);
            return object;
        } catch (DatabindException e) {
            throw new ApplicationException("Неверный формат входного файла");
        } catch (Exception e) {
            throw new ApplicationException("Ошибка при чтении входного файла");
        }
    }
}
