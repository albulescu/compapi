package comapi.api.company;

import static spark.Spark.get;

import comapi.Di;
import comapi.Facade;
import comapi.Preferences;
import spark.Request;
import spark.Response;
import spark.Route;

public class CompanyFacade implements Facade {
    
    private Di di;
    
    public CompanyFacade( Di di ) {
        this.di = di;
    }
    
    private CompanyRepository repository() {
        return di.get("companies").as(CompanyRepository.class);
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
    
    public void init( Preferences prefs ) {
        get("/create", prefs.getAcceptType(), getCompanyCreateHandler(), prefs.getResponseTransformer());
        get("/view/:id", prefs.getAcceptType(), getCompanyViewHandler(), prefs.getResponseTransformer());
    }
}
