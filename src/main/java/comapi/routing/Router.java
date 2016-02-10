package comapi.routing;

import java.util.logging.Logger;

import comapi.Di;
import comapi.Facade;
import spark.Route;
import spark.Spark;

public class Router implements RouterVerbs {
    
    Di di;
    RouterPreferences preferences;
    
    public Router(Di di, RouterPreferences preferences) {
        this.di = di;
        this.preferences = preferences;
    }
    
    public void facade( String prefix, Facade facade ) {
        facade.setDi(di);
        facade.init(new FacadeRouter(prefix, this));
    }

    private String path(String base) {
        
        if( base.subSequence(base.length() - 1, base.length()).equals("/")) {
            base = base.substring(0, base.length() - 1);
        }
        
        Logger log = Logger.getLogger("Router");
        log.info("Map route -> " + base);
        
        return preferences.getPrefix() + base;
    }
    
    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#get(java.lang.String, spark.Route)
     */
    @Override
    public void get(String path, Route route) {
        Spark.get(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }

    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#post(java.lang.String, spark.Route)
     */
    @Override
    public void post(String path, Route route) {
        Spark.post(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }

    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#delete(java.lang.String, spark.Route)
     */
    @Override
    public void delete(String path, Route route) {
        Spark.delete(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }

    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#put(java.lang.String, spark.Route)
     */
    @Override
    public void put(String path, Route route) {
        Spark.put(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }

    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#patch(java.lang.String, spark.Route)
     */
    @Override
    public void patch(String path, Route route) {
        Spark.patch(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }

    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#head(java.lang.String, spark.Route)
     */
    @Override
    public void head(String path, Route route) {
        Spark.head(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }

    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#trace(java.lang.String, spark.Route)
     */
    @Override
    public void trace(String path, Route route) {
        Spark.trace(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }

    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#connect(java.lang.String, spark.Route)
     */
    @Override
    public void connect(String path, Route route) {
        Spark.connect(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }

    /* (non-Javadoc)
     * @see comapi.routing.RouterVerbs#options(java.lang.String, spark.Route)
     */
    @Override
    public void options(String path, Route route) {
        Spark.options(path(path), preferences.getDefaultAcceptType(), route, preferences.getResponseTransformer());
    }
}
