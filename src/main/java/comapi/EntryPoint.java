package comapi;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class EntryPoint {
    public static void main(String[] args) {
        try {
            Application.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
