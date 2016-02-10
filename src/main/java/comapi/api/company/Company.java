package comapi.api.company;

import java.util.ArrayList;
import java.util.List;

import comapi.repository.Entity;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class Company extends Entity {

    @NotNull
    @NotEmpty
    public String name;
    
    @NotNull
    @NotEmpty
    public String address;
    
    @NotNull
    @NotEmpty
    public String city;
    
    @NotNull
    @NotEmpty
    public String country;
    
    @NotEmpty
    public String email;
    
    @NotEmpty
    public String phone;
    
    public List<Employee> employees = new ArrayList<Employee>();
}
