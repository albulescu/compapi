package comapi.repository;

public class Repository {
    
    RepositoryStorage storage;
    
    public Repository( RepositoryStorage storage ) {
        this.storage = storage;
    }

    /**
     * @return the storage
     */
    public RepositoryStorage getStorage() {
        return storage;
    }
}
