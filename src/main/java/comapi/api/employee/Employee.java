package comapi.api.employee;

import comapi.api.company.Company;
import comapi.api.users.User;
import comapi.repository.Entity;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class Employee extends Entity {

    @NotNull
    @NotEmpty
    public String company;

    @NotNull
    @NotEmpty
    public String user;
    
    @NotNull
    public EmployeeRole role = EmployeeRole.GENERIC;
    
    public Employee(Company company, User user, EmployeeRole role) {
        this.company = company.id;
        this.user = user.id;
        this.role = role;
    }
}
