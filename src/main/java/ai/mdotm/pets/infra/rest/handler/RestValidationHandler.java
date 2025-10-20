package ai.mdotm.pets.infra.rest.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class RestValidationHandler {


        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {

            List<Map<String, String>> errors = ex.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(err -> Map.of(
                            "field", err.getField(),
                            "message", err.getDefaultMessage()))
                    .toList();

            Map<String, Object> body = Map.of(
                    "status", 400,
                    "error", "Bad Request",
                    "message", "Validation failed",
                    "details", errors
            );

            return ResponseEntity.badRequest().body(body);
    }
}
