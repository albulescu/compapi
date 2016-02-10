package comapi;

import static org.junit.Assert.*;

import org.junit.Test;

import comapi.repository.Entity;

public class DiTest {

    @Test
    public void testRegisterClass() {
        Di di = new Di();
        di.mapSingleton("test", Entity.class);
        Entity a = di.get("test").as(Entity.class);
        Entity b = di.get("test").as(Entity.class);
        assertSame(a, b);
    }
    
    @Test
    public void testShoudCreateNewInstance() {
        Di di = new Di();
        di.mapFactory("test", new Di.Factory() {
            @Override
            public Object create(Di di) {
                return new Entity();
            }
        });
        
        Entity a = di.get("test").as(Entity.class);
        Entity b = di.get("test").as(Entity.class);
        assertNotSame(a, b);
    }
    
    @Test
    public void testWillSetValue() {
        Di di = new Di();
        di.mapValue("test", 1);
        if( di.getInt("test") != 1 ) {
            fail("Should be equal with 1");
        }
    }

}
