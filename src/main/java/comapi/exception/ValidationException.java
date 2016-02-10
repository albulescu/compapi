package comapi.exception;

import static spark.Spark.halt;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import spark.HaltException;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class ValidationException {

    public static void throwViolations(List<ConstraintViolation> violations) throws HaltException {
        // TODO: Proper error messages
        ConstraintViolation first = violations.get(0);
        halt(400, first.getMessage());
    }
}
