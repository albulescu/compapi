package comapi.api.employee;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public enum EmployeeRole {
    GENERIC(), OWNER();

    public static EmployeeRole fromString(String role) {
        
        if( role.toLowerCase().equals("owner") ) {
            return EmployeeRole.OWNER;
        }
        else if( role.toLowerCase().equals("generic") ) {
            return EmployeeRole.GENERIC;
        }
            
        return null;
    }
}
