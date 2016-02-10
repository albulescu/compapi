package comapi.repository;

public class Entity {
    
    private String id;

    public Entity() {}
    
    public Entity(String id) {
        this.id = id;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
