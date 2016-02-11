package comapi.api.company;

import static spark.Spark.*;

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
public class CompanyFacade extends Facade {

    private CompanyRepository repository() {
        return getDi().get("repository.companies").as(CompanyRepository.class);
    }

    protected Route getCompanyCreateHandler() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                Company company = new Company();
                company.fromJson(request.body());

                Validator validator = new Validator();
                List<ConstraintViolation> violations = validator.validate(company);

                if (violations.size() > 0) {
                    ValidationException.throwViolations(violations);
                }

                repository().addCompany(company);
                return company;
            }
        };
    }

    protected Route getCompanyViewHandler() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {

                Company company = repository().getCompany(request.params("id"));

                if (company == null) {
                    halt(404, "Company not found");
                }

                return company;
            }
        };
    }

    protected Route getCompaniesHandler() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return repository().getAll();
            }
        };
    }

    @Override
    public void init(FacadeRouter router) {
        router.post("/", getCompanyCreateHandler());
        router.get("/", getCompaniesHandler());
        router.get("/:id", getCompanyViewHandler());
    }
}
