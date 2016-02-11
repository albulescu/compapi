package comapi.api.employee;

import com.google.gson.Gson;

import comapi.Facade;
import comapi.api.company.Company;
import comapi.api.company.CompanyRepository;
import comapi.api.users.User;
import comapi.api.users.UsersRepository;
import comapi.exception.ValidationException;
import comapi.routing.FacadeRouter;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.halt;

import java.util.List;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class EmployeeFacade extends Facade {

    @Override
    public void init(FacadeRouter router) {
        router.post("/", getEmployeeCreateRoute());
    }
    
    private CompanyRepository companies() {
        return getDi().get("repository.companies").as(CompanyRepository.class);
    }

    private UsersRepository users() {
        return getDi().get("repository.users").as(UsersRepository.class);
    }

    private EmployeeRepository employees() {
        return getDi().get("repository.employees").as(EmployeeRepository.class);
    }
    
    private Route getEmployeeCreateRoute() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                Gson gson = new Gson();
                CreateEmployee create = gson.fromJson(request.body(), CreateEmployee.class);
                
                Validator validator = new Validator();
                List<ConstraintViolation> violations = validator.validate(create);

                if (violations.size() > 0) {
                    halt(400, violations.get(0).getMessage());
                }
                
                Company company = companies().getCompany(create.company);
                if(company == null) {
                    halt(400, "Company not found");
                }
                
                User user = users().getUser(create.user);
                if( user == null) {
                    halt(400, "User not found");
                }
                
                EmployeeRole role = EmployeeRole.fromString(create.role);
                if( role == null ) {
                    halt(400, "Invalid roles");
                }
                
                Employee employee = employees().getEmployee(company, user);
                
                if( employee != null ) {
                    halt(400, "Employee already exists");
                }
                
                Employee newEmplyee = new Employee( company, user, role );
                
                employees().addEmployee(newEmplyee);
                
                return newEmplyee;
            }
        };
    }
}
