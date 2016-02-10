package comapi.api.company;

import compapi.api.users.User;
import net.sf.oval.constraint.NotNull;

public class Employee extends User {
    
    @NotNull
    public EmployeeRole role = EmployeeRole.GENERIC;
}
