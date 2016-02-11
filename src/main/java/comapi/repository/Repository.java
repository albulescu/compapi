package comapi.repository;

import comapi.Di;
import comapi.DiAware;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class Repository implements DiAware {

    Di di;
    RepositoryStorage storage;

    public Repository(RepositoryStorage storage) {
        this.storage = storage;
    }

    /**
     * @return the storage
     */
    public RepositoryStorage getStorage() {
        
        if( storage.getName() == null ) {
            storage.setName(this.getClass().getName());
        }
        
        return storage;
    }

    @Override
    public void setDi(Di di) {
        this.di = di;
    }

    @Override
    public Di getDi() {
        return di;
    }
}
