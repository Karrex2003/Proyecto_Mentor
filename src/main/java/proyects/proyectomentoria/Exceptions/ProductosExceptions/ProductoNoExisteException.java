package proyects.proyectomentoria.Exceptions.ProductosExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProductoNoExisteException extends RuntimeException{
    public ProductoNoExisteException(String message){
        super(message);
    }
}
