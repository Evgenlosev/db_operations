package ru.aikam.testTask.losev;

import ru.aikam.testTask.losev.exceptions.ApplicationError;
import ru.aikam.testTask.losev.exceptions.ApplicationException;
import ru.aikam.testTask.losev.request.SearchRequest;
import ru.aikam.testTask.losev.request.StatRequest;
import ru.aikam.testTask.losev.response.SearchResponse;
import ru.aikam.testTask.losev.response.StatResponse;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class MainApp {

    private static ObjectMapper objectMapper;
    public static void main(String[] args) {

        try {
            start(args);
        } catch (ApplicationException e) {
            parseObjectToJson(new File(args[2]), new ApplicationError(e.getMessage()));
        }
    }

    private static void start(String[] args) throws ApplicationException {
        if (args.length != 3) {
            log.error("Неверный формат ввода команды");
            System.exit(1);
        }

        String commandType = args[0].toLowerCase();
        File inputFile = new File(args[1]);
        File outputFile = new File(args[2]);
        objectMapper = new ObjectMapper();

        if (!inputFile.exists()) {
            throw new ApplicationException("Не найден входной файл");
        }
        if (!inputFile.canRead()) {
            throw new ApplicationException("Ошибка доступа к входному файлу");
        }

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
            default:
                throw new ApplicationException("Неверно указан тип операции в запросе");
        }
    }

    private static void parseObjectToJson(File outputFile, Object object) {
        try {
            objectMapper.writeValue(outputFile, object);
        } catch (Exception e) {
            e.printStackTrace();
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
