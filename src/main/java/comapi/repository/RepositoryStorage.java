package comapi.repository;

import java.util.List;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public interface RepositoryStorage {

    /**
     * Find an entity based on a query
     * 
     * @param query
     * @return
     */
    public List<Entity> find(EntityQuery query);
    
    /**
     * Find one entity
     * @param query
     * @return
     */
    public Entity findOne(EntityQuery query);
    
    /**
     * Store new entity or update
     * 
     * @param data
     */
    public void save(Entity data);

    /**
     * Get an entity
     * 
     * @param id
     * @return
     */
    public Entity get(String id);

    /**
     * Get all entities
     * 
     * @return
     */
    public List<Entity> all();

    /**
     * Get all entities with a limit
     * 
     * @param limit
     * @return
     */
    public List<Entity> all(int limit);

    /**
     * Get all entities with pagination capabilities
     * 
     * @param limit
     * @param offset
     * @return
     */
    public List<Entity> all(int limit, int offset);

    /**
     * Count all entities from this store
     * 
     * @return
     */
    public int count();
    
    /**
     * Name of this storage bag
     * @return
     */
    public void setName(String name);
    
    /**
     * Name of this storage bag
     * @return
     */
    public String getName();
}
