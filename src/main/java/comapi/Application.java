package comapi;

import comapi.api.company.CompanyFacade;
import comapi.api.company.CompanyRepository;
import comapi.repository.RepositoryMemoryStorage;
import comapi.repository.RepositoryStorage;

public class Application {

    static Preferences prefs = new Preferences();
    
    private static void mapFacade(Facade facade) { 
        facade.init(prefs);
    }

    public static void load() throws Exception {
        
        Di di = new Di();
        
        di.mapSingleton("storage", RepositoryMemoryStorage.class);
        
        di.mapSingleton("companies", di1 -> new CompanyRepository(
                di1.get("storage").as(RepositoryStorage.class)
        ));
        
        mapFacade(new CompanyFacade(di));
    }
}
