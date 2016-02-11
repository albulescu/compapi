package comapi.api.employee;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class CreateEmployee {
    
    @NotNull
    @NotEmpty
    public String company;
    
    @NotNull
    @NotEmpty
    public String user;
    
    @NotNull
    @NotEmpty
    public String role;
}
