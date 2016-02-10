package comapi.api.company;

import comapi.repository.Repository;
import comapi.repository.RepositoryStorage;

public class CompanyRepository extends Repository {

    public CompanyRepository(RepositoryStorage storage) {
        super(storage);
    }

    
    public void addCompany(Company company) {
        getStorage().set(company);
    }
    
    public Company getCompany(int id) {
        return (Company) getStorage().get( id + "" );
    }
}
