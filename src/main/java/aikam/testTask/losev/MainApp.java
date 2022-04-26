package aikam.testTask.losev;

import aikam.testTask.losev.exceptions.ApplicationError;
import aikam.testTask.losev.exceptions.ApplicationException;
import aikam.testTask.losev.request.SearchRequest;
import aikam.testTask.losev.request.StatRequest;
import aikam.testTask.losev.response.SearchResponse;
import aikam.testTask.losev.response.StatResponse;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class MainApp {

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
            System.out.println("Неверный формат ввода команды");
            return;
        }

        File outputFile = new File(args[2]);
        if (!outputFile.canWrite()) {
            System.out.println("Ошибка доступа к выходному файлу");
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
        ObjectMapper objectMapper = new ObjectMapper();

        switch (commandType) {
            case ("search"):
                SearchRequest searchRequest = parseObjectFromJson(objectMapper, inputFile, SearchRequest.class);
                SearchResponse searchResponse = RequestHandler.requestHandling(searchRequest);
                parseObjectToJson(objectMapper, outputFile, searchResponse);
            case ("stat"):
                StatRequest statRequest = parseObjectFromJson(objectMapper,inputFile, StatRequest.class);
                StatResponse statResponse = RequestHandler.requestHandling(statRequest);
                parseObjectToJson(objectMapper, outputFile, statResponse);
        }
    }

    private static void parseObjectToJson(ObjectMapper objectMapper, File outputFile, Object object) throws ApplicationException {
        try {
            objectMapper.writeValue(outputFile, object);
        } catch (Exception e) {
            throw new ApplicationException("Ошибка при создании выходного файла");

        }
    }

    private static <T> T parseObjectFromJson (ObjectMapper objectMapper, File src, Class<T> valueType) throws ApplicationException {
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
