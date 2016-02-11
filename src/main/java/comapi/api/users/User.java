package comapi.api.users;

import comapi.repository.Entity;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class User extends Entity {

    @NotNull
    @NotEmpty
    public String name;
    
    @NotNull
    @NotEmpty
    public String email;
}
