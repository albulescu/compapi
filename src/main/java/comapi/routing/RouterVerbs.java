package comapi.routing;

import spark.Route;

public interface RouterVerbs {
    public void get(String path, Route route);
    public void post(String path, Route route);
    public void delete(String path, Route route);
    public void put(String path, Route route);
    public void patch(String path, Route route);
    public void head(String path, Route route);
    public void trace(String path, Route route);
    public void connect(String path, Route route);
    public void options(String path, Route route);
}
