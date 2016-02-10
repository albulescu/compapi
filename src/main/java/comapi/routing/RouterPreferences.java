package comapi.routing;

import spark.ResponseTransformer;

/**
 * @author Cosmin Albulescu <cosmin@albulescu.ro>
 */
public class RouterPreferences {

    private String prefix = "/v1";

    private String defaultAcceptType = "application/json";

    private ResponseTransformer responseTransformer = new JsonTransformer();

    /**
     * @return the acceptType
     */
    public String getDefaultAcceptType() {
        return defaultAcceptType;
    }

    /**
     * @param acceptType
     *            the acceptType to set
     */
    public void setDefaultAcceptType(String acceptType) {
        this.defaultAcceptType = acceptType;
    }

    /**
     * @return the responseTransformer
     */
    public ResponseTransformer getResponseTransformer() {
        return responseTransformer;
    }

    /**
     * @param responseTransformer
     *            the responseTransformer to set
     */
    public void setResponseTransformer(ResponseTransformer responseTransformer) {
        this.responseTransformer = responseTransformer;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix
     *            the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
