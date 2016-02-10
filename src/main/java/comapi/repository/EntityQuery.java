package comapi.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Most complex queries
 * 
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class EntityQuery {

    private Map<String, String> map = new HashMap<String, String>();

    public EntityQuery() {
    }

    public EntityQuery(String property, String value) {
        addTerm(property, value);
    }

    public void addTerm(String property, String value) {
        map.put(property, value);
    }

    public Map<String, String> getTerms() {
        return map;
    }
}
