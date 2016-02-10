package comapi;

import java.util.HashMap;

public class Di {
    
    private HashMap<String, Class<?>> singletones;
    private HashMap<String, Factory<?>> factories;
    private HashMap<String, Factory<?>> singletonesFactories;
    private HashMap<String, Object> values;
    
    public Di() {
        singletones = new HashMap<String,Class<?>>();
        factories = new  HashMap<String, Factory<?>>();
        singletonesFactories = new  HashMap<String, Factory<?>>();
        values = new HashMap<String, Object>();
    }
    
    private boolean nameIsValid(String name) {
        if( singletones.containsKey(name) || 
            factories.containsKey(name) || 
            singletonesFactories.containsKey(name) || 
            values.containsKey(name) ) {
            return false;
        }
        return true;
    }
    
    public boolean mapSingleton(String name, Class<?> clazz) {
        if(!nameIsValid(name)) {
            return false;
        }
        singletones.put(name, clazz);
        return true;
    }

    public boolean mapSingleton(String name, Factory<?> factory) {
        if(!nameIsValid(name)) {
            return false;
        }
        singletonesFactories.put(name, factory);
        return true;
    }
    
    public boolean mapFactory(String name, Factory<?> factory) {
        if(!nameIsValid(name)) {
            return false;
        }
        factories.put(name, factory);
        return true;
    }
    
    public boolean mapValue(String name, Object value) {
        if(!nameIsValid(name)) {
            return false;
        }
        values.put(name, value);
        return true;
    }
    
    public String getString(String name) {
        return get(name).as(String.class);
    }

    public int getInt(String name) {
        return get(name).as(int.class);
    }
    
    public Value get(String name) {
        
        if(values.containsKey(name)) {
           return new Value(values.get(name)); 
        }
        
        if(factories.containsKey(name)) {
            return new Value( factories.get(name).create(this) );
        }
        
        if(singletones.containsKey(name)) {
            
            try {
                values.put(name, singletones.get(name).newInstance());
                return get(name);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            
            return null;
        }

        if(singletonesFactories.containsKey(name)) {
            values.put(name, singletonesFactories.get(name).create(this));
            return get(name);
        }
        
        return null;
    }
    
    public interface Factory<T> {
        public T create(Di di);
    }
    
    public class Value {
        
        private Object value;
        
        public Value(Object value){
            this.value = value;
        }
        
        public Object getValue() {
            return value;
        }
        
        @SuppressWarnings({ "unchecked", "unused" })
        public final <T> T as(final Class<T> clazz) {
            return (T) value;
        }
    }
}
