package proyects.proyectomentoria.Exceptions.ProductosExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ProductoExistenteException extends RuntimeException{
    public ProductoExistenteException(String message){
        super(message);
    }
}
