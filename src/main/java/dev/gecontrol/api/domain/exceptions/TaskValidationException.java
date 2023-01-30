package dev.gecontrol.api.domain.exceptions;

import java.util.List;

public class TaskValidationException extends Exception {
    private List<String> errors;
    
    public TaskValidationException(List<String> errors) {
        super("Validation errors: " + errors.toString());
        this.errors = errors;
    }
    
    public List<String> getErrors() {
        return errors;
    }
}