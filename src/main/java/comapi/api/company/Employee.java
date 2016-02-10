package comapi.api.company;

import comapi.api.users.User;
import net.sf.oval.constraint.NotNull;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class Employee extends User {

    @NotNull
    public EmployeeRole role = EmployeeRole.GENERIC;
}
