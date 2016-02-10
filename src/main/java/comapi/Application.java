package comapi;

import comapi.api.company.CompanyFacade;
import comapi.api.company.CompanyRepository;
import comapi.api.users.UsersFacade;
import comapi.api.users.UsersRepository;
import comapi.repository.RepositoryMemoryStorage;
import comapi.repository.RepositoryStorage;
import comapi.routing.Router;
import comapi.routing.RouterPreferences;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class Application {

    static RouterPreferences prefs = new RouterPreferences();
    
    public static void load() throws Exception {
        
        Di di = new Di();
        
        /**
         * Register data repositories
         */

        di.mapSingleton("storage", RepositoryMemoryStorage.class);
        
        di.mapSingleton("repository.companies", di1 -> new CompanyRepository(
                di1.get("storage").as(RepositoryStorage.class)
        ));

        di.mapSingleton("repository.users", di1 -> new UsersRepository(
                di1.get("storage").as(RepositoryStorage.class)
        ));
        
        
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
    }
}
