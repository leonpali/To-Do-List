package projects.java.todolist.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import projects.java.todolist.application.InvalidTaskException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidTaskException.class)
    public ResponseEntity<String> handleInvalidTask(InvalidTaskException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingParam(MissingServletRequestParameterException ex) {
        if (ex.getParameterName().equals("taskDate")) {
            return ResponseEntity.badRequest().body("Datum darf nicht leer sein");
        }
        return ResponseEntity.badRequest().body("Fehlender Parameter: " + ex.getParameterName());
    }
}
