package ru.aikam.testTask.losev.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApplicationError {
    private final String type = "error";
    private String message;

    public ApplicationError(String message) {
        this.message = message;
    }
}
