package mx.uady.sicei.exception;
/**
 * Una clase para manejo de excepciones para denegar acceso
 * @author Samantha Caamal, Montserrat Bustamante 
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        super("Acceso denegado");
    }

    public ForbiddenException(String mensaje) {
        super(mensaje);
    }
}
