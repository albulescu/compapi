package comapi.api.company;

import static spark.Spark.*;

import comapi.Di;
import comapi.Facade;
import comapi.routing.FacadeRouter;
import comapi.routing.Router;
import comapi.routing.RouterPreferences;
import spark.Request;
import spark.Response;
import spark.Route;

public class CompanyFacade extends Facade {
    
    private CompanyRepository repository() {
        return getDi().get("companies").as(CompanyRepository.class);
    }
    
    protected Route getCompanyCreateHandler() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                Company company = new Company("My Company");
                repository().addCompany(company);
                return company;
            }
        };
    }
    
    protected Route getCompanyViewHandler() {
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return repository().getCompany(Integer.parseInt(request.params("id")));
            }
        };
    }
    
    @Override
    public void init(FacadeRouter router) {
        router.get("/", getCompanyCreateHandler());
        router.get("/:id", getCompanyViewHandler());
    }
}
