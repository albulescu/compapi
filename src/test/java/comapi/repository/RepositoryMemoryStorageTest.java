package comapi.repository;

import static org.junit.Assert.*;

import org.junit.Test;

public class RepositoryMemoryStorageTest {

    @Test
    public void testCanAddEntity() {
        RepositoryMemoryStorage storage = new RepositoryMemoryStorage();
        Entity entity = new Entity();
        assertEquals(null, entity.id);
        storage.set(entity);
        assertEquals("0", entity.id);
        storage.set(new Entity());
        assertEquals("1", storage.get("1").id);
    }

}
