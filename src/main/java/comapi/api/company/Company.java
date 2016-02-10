package comapi.api.company;

import comapi.repository.DtoProperty;
import comapi.repository.Entity;

public class Company extends Entity {

    private String name;
    
    public Company(String name) {
        super();
        this.name = name;
    }

    /**
     * @return the name
     */
    @DtoProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
