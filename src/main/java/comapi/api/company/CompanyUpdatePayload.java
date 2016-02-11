package comapi.api.company;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.NotEmpty;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class CompanyUpdatePayload {
    
    @NotEmpty
    public String name;

    @NotEmpty
    public String address;

    @NotEmpty
    public String city;

    @NotEmpty
    public String country;

    @NotEmpty
    public String email;

    @NotEmpty
    public String phone;
    
    public boolean isValid() {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(this);
        return violations.size() == 0;
    }

    public int update(Company company) {
        
        int changes = 0;
        
        if( name != null ) {
            company.name = name;
            changes++;
        }
        
        if( address != null ) {
            company.address = address;
            changes++;
        }
        
        if( city != null ) {
            company.city = city;
            changes++;
        }
        
        if( country != null ) {
            company.country = country;
            changes++;
        }
        
        if( email != null ) {
            company.email = email;
            changes++;
        }
        
        if( phone != null ) {
            company.phone = phone;
            changes++;
        }
        
        return changes;
    }
}
