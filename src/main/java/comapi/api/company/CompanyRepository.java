package comapi.api.company;

import java.util.ArrayList;
import java.util.List;

import comapi.api.employee.EmployeeRepository;
import comapi.repository.Entity;
import comapi.repository.Repository;
import comapi.repository.RepositoryStorage;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class CompanyRepository extends Repository {

    public CompanyRepository(RepositoryStorage storage) {
        super(storage);
    }

    private Company populate(Company company) {
        
        if( company == null ) {
            return company;
        }
        
        EmployeeRepository employees = getDi().get("repository.employees").as(EmployeeRepository.class);
        company.employees = employees.getEmployees(company);
        return company;
    }
    
    public List<Company> getAll() {
        List<Company> items = new ArrayList<Company>();
        for (Entity e : getStorage().all()) {
            items.add(populate((Company) e));
        }
        return items;
    }

    public void addCompany(Company company) {
        getStorage().save(company);
    }

    public Company getCompany(String company) {
        return populate((Company) getStorage().get(company));
    }

    public void updateCompany(Company company) {
        getStorage().save(company);
    }
}
