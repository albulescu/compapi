package compapi.api.users;

import comapi.repository.Entity;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class User extends Entity {
    
    @NotNull
    @NotEmpty
    public String name;
}
