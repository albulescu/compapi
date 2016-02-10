package comapi.api.users;

import java.util.ArrayList;
import java.util.List;

import comapi.repository.Entity;
import comapi.repository.Repository;
import comapi.repository.RepositoryStorage;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class UsersRepository extends Repository {

    public UsersRepository(RepositoryStorage storage) {
        super(storage);
    }

    public List<User> getAll() {
        List<User> items = new ArrayList<User>();
        for (Entity e : getStorage().all()) {
            items.add((User) e);
        }
        return items;
    }

    public void addUser(User user) {
        getStorage().set(user);
    }
}
