package comapi.api.users;

import static spark.Spark.halt;

import java.util.List;

import comapi.Facade;
import comapi.exception.ValidationException;
import comapi.routing.FacadeRouter;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class UsersFacade extends Facade {

    @Override
    public void init(FacadeRouter router) {
        router.post("/", getCreateUserHandler());
        router.get("/", getListUsersHandler());
    }

    private UsersRepository repository() {
        return getDi().get("repository.users").as(UsersRepository.class);
    }

    private Route getListUsersHandler() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return repository().getAll();
            }
        };
    }

    private Route getCreateUserHandler() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                User user = new User();
                user.fromJson(request.body());

                Validator validator = new Validator();
                List<ConstraintViolation> violations = validator.validate(user);

                if (violations.size() > 0) {
                    ValidationException.throwViolations(violations);
                }

                User exists = repository().getUserByEmail(user.email);
                
                if( exists != null ) {
                    halt(400, "User with this email already exists");
                }
                
                repository().addUser(user);
                return user;
            }
        };
    }
}
