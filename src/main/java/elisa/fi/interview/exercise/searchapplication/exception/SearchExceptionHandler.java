package elisa.fi.interview.exercise.searchapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class SearchExceptionHandler {

    @ExceptionHandler(SearchException.class)
    public ResponseEntity<SearchErrorMessage> resourceNotFoundException(SearchException ex, WebRequest request) {
        SearchErrorMessage message = new SearchErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<SearchErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SearchErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
        SearchErrorMessage message = new SearchErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                "Invalid Input!! ...Try entering positive integers.",
                request.getDescription(false));

        return new ResponseEntity<SearchErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }
}