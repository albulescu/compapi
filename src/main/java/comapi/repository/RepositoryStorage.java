package comapi.repository;

import java.util.List;

public interface RepositoryStorage {

    public List<Entity> find(EntityQuery query);
    
    public void set(Entity data);

    public Entity get(String id);

    public List<Entity> all();

    public List<Entity> all(int limit);

    public List<Entity> all(int limit, int offset);
    
    public int count();
}
