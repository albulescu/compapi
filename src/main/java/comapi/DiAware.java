package comapi;

/**
 * Interface used to apply di to objects from it
 * 
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public interface DiAware {
    public void setDi(Di di);
    public Di getDi();
}
