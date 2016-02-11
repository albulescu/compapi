package comapi.api.employee;

import java.util.ArrayList;
import java.util.List;

import comapi.api.company.Company;
import comapi.api.users.User;
import comapi.repository.Entity;
import comapi.repository.EntityQuery;
import comapi.repository.Repository;
import comapi.repository.RepositoryStorage;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class EmployeeRepository extends Repository {

    public EmployeeRepository(RepositoryStorage storage) {
        super(storage);
        storage.setName("employees");
    }

    public void addEmployee(Employee employee) {
        getStorage().set(employee);
    }
    
    public List<Employee> getEmployees(Company company) {
        List<Entity> results = getStorage().find(new EntityQuery("company", company.id));
        List<Employee> employees = new ArrayList<Employee>();
        for(Entity e : results) {
            employees.add((Employee) e);
        }
        return employees;
    }
    
    public Employee getEmployee(Company company, User user) {
        EntityQuery query = new EntityQuery();
        query.addTerm("company", company.id);
        query.addTerm("user", user.id);
        return (Employee) getStorage().findOne(query);
    }
}
