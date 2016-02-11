package comapi.api.company;

import static spark.Spark.*;

import java.util.List;

import com.google.gson.Gson;

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
    
    @Override
    public void init(FacadeRouter router) {
        router.post("/", getCompanyCreateHandler());
        router.get("/", getCompaniesHandler());
        router.get("/:id", getCompanyViewHandler());
        router.put("/:id", getCompanyUpdateHandler());
    }
    
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

    private Route getCompanyUpdateHandler() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                Gson gson = new Gson();
                CompanyUpdatePayload updatePayload = gson.fromJson(request.body(), CompanyUpdatePayload.class);
                
                if(!updatePayload.isValid()) {
                    halt(400, "Invalid update payload");
                }
                
                Company company = repository().getCompany( request.params("id") );
                
                if( company == null ) {
                    halt(404, "Company not found");
                }
                
                int changes = updatePayload.update(company);
                
                if( changes > 0 ) {
                    repository().updateCompany(company);
                }
                
                return company;
            }
        };
    }
}
