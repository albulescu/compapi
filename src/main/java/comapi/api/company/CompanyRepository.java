package comapi.api.company;

import java.util.ArrayList;
import java.util.List;

import comapi.repository.Entity;
import comapi.repository.Repository;
import comapi.repository.RepositoryStorage;

public class CompanyRepository extends Repository {

    public CompanyRepository(RepositoryStorage storage) {
        super(storage);
    }

    public List<Company> getAll() {
        List<Company> items = new ArrayList<Company>();
        for(Entity e : getStorage().all()) {
            items.add((Company) e);
        }
        return items;
    }
    
    public void addCompany(Company company) {
        getStorage().set(company);
    }
    
    public Company getCompany(int id) {
        return (Company) getStorage().get( id + "" );
    }
}
