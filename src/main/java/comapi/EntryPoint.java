package comapi;

public class EntryPoint {
    public static void main(String[] args) {
        try {
            Application.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
