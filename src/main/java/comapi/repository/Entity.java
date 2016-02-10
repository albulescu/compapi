package comapi.repository;

import java.lang.reflect.Field;

import com.google.gson.Gson;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class Entity {

    public String id;

    public Entity() {
    }

    public Entity(String id) {
        this.id = id;
    }

    /**
     * Populate this entity from json
     * @param json
     */
    public void fromJson(String json) {

        Gson gson = new Gson();
        Class<?> clazz = this.getClass();
        Object data = gson.fromJson(json, clazz);

        if (data == null) {
            return;
        }

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.set(this, field.get(data));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
