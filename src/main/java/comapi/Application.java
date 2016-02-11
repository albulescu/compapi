package comapi;

import comapi.api.company.CompanyFacade;
import comapi.api.company.CompanyRepository;
import comapi.api.employee.EmployeeFacade;
import comapi.api.employee.EmployeeRepository;
import comapi.api.users.UsersFacade;
import comapi.api.users.UsersRepository;
import comapi.repository.RepositoryMemoryStorage;
import comapi.repository.RepositoryStorage;
import comapi.routing.Router;
import comapi.routing.RouterPreferences;
import comapi.Di.Factory;
import spark.Spark;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class Application {

    static RouterPreferences prefs = new RouterPreferences();
    
    public static void load() throws Exception {
        
        String port = System.getenv("PORT");
        
        if( port != null ) {
            Spark.port( Integer.parseInt(port) );
        }
        
        Di di = new Di();
        
        /**
         * Register data repositories
         */

        di.mapFactory("storage", new Factory<RepositoryMemoryStorage>() {
            @Override
            public RepositoryMemoryStorage create(Di di) {
                return new RepositoryMemoryStorage();
            }
        });
        
        di.mapSingleton("repository.companies", new Factory<CompanyRepository>() {
            @Override
            public CompanyRepository create(Di di) {
                return new CompanyRepository(
                        di.get("storage").as(RepositoryStorage.class)
                );
            }
        });

        di.mapSingleton("repository.users", new Factory<UsersRepository>() {
            @Override
            public UsersRepository create(Di di) {
                return new UsersRepository(
                        di.get("storage").as(RepositoryStorage.class)
                );
            }
        });

        di.mapSingleton("repository.employees", new Factory<EmployeeRepository>() {
            @Override
            public EmployeeRepository create(Di di) {
                return new EmployeeRepository(
                        di.get("storage").as(RepositoryStorage.class)
                );
            }
        });

        
        
        /**
         * Create router
         */
        RouterPreferences routePreferences = new RouterPreferences();
        Router router = new Router(di, routePreferences);
        di.mapValue("router", router);
        
        
        /**
         * Register facade routes
         */
        router.facade("/users", new UsersFacade());
        router.facade("/companies", new CompanyFacade());
        router.facade("/employees", new EmployeeFacade());
    }
}
