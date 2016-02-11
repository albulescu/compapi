package comapi.repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class RepositoryMemoryStorage implements RepositoryStorage {

    private List<Entity> storage;

    public RepositoryMemoryStorage() {
        storage = new ArrayList<Entity>();
    }

    @Override
    public List<Entity> find(EntityQuery query) {

        List<Entity> results = new ArrayList<Entity>();

        for (Entity e : storage) {
            for (Entry<String, String> term : query.getTerms().entrySet()) {
                try {
                    Field field = e.getClass().getDeclaredField(term.getKey());
                    if (field.get(e).equals(term.getValue())) {
                        results.add(e);
                    }
                } catch (Exception e1) {
                }
            }
        }

        return results;
    }

    @Override
    public void set(Entity data) {

        if (data.id == null) {
            data.id = storage.size() + 1 + "";
            storage.add(data);
            return;
        }

        int position = 0;
        for (Entity e : storage) {
            if (e.id != null && e.id.equals(data.id)) {
                storage.set(position, data);
            }
            position++;
        }
    }

    @Override
    public Entity get(String id) {
        for (Entity e : storage) {
            if (e.id != null && e.id.equals(id)) {
                return e;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.repository.RepositoryStorage#all()
     */
    @Override
    public List<Entity> all() {
        return storage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.repository.RepositoryStorage#all(int)
     */
    @Override
    public List<Entity> all(int limit) {
        return storage.subList(0, limit);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.repository.RepositoryStorage#all(int, int)
     */
    @Override
    public List<Entity> all(int limit, int offset) {
        return storage.subList(offset, offset + limit);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.repository.RepositoryStorage#count()
     */
    @Override
    public int count() {
        return storage.size();
    }
}
