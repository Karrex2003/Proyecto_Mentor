package proyects.proyectomentoria.Exceptions.ProductosExceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import proyects.proyectomentoria.Exceptions.ApiError;
import proyects.proyectomentoria.Exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ProductosExceptionHandler {

    @ExceptionHandler(ProductoExistenteException.class)
    public ResponseEntity<ApiError> handleException(ProductoExistenteException e,
                                                    HttpServletRequest request){
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CategoriaNoExisteException.class)
    public ResponseEntity<ApiError> handleException(CategoriaNoExisteException e,
                                                    HttpServletRequest request){
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ProductoNoExisteException.class)
    public ResponseEntity<ApiError> handleException(ProductoNoExisteException e,
                                                    HttpServletRequest request){
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

}
