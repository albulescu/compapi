package comapi.routing;

import spark.Route;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class FacadeRouter implements HttpVerbs {

    private String prefix;
    private Router router;

    public FacadeRouter(String prefix, Router router) {
        this.prefix = prefix;
        this.router = router;
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#get(java.lang.String, spark.Route)
     */
    @Override
    public void get(String path, Route route) {
        router.get(prefix + path, route);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#post(java.lang.String, spark.Route)
     */
    @Override
    public void post(String path, Route route) {
        router.post(prefix + path, route);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#delete(java.lang.String, spark.Route)
     */
    @Override
    public void delete(String path, Route route) {
        router.delete(prefix + path, route);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#put(java.lang.String, spark.Route)
     */
    @Override
    public void put(String path, Route route) {
        router.put(prefix + path, route);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#patch(java.lang.String, spark.Route)
     */
    @Override
    public void patch(String path, Route route) {
        router.patch(prefix + path, route);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#head(java.lang.String, spark.Route)
     */
    @Override
    public void head(String path, Route route) {
        router.head(prefix + path, route);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#trace(java.lang.String, spark.Route)
     */
    @Override
    public void trace(String path, Route route) {
        router.trace(prefix + path, route);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#connect(java.lang.String, spark.Route)
     */
    @Override
    public void connect(String path, Route route) {
        router.connect(prefix + path, route);
    }

    /*
     * (non-Javadoc)
     * 
     * @see comapi.routing.RouterVerbs#options(java.lang.String, spark.Route)
     */
    @Override
    public void options(String path, Route route) {
        router.options(prefix + path, route);
    }
}
