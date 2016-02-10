package comapi;

import spark.ResponseTransformer;

public class Preferences {
    
    private String acceptType = "application/json";
    
    private ResponseTransformer responseTransformer = new JsonTransformer();

    /**
     * @return the acceptType
     */
    public String getAcceptType() {
        return acceptType;
    }

    /**
     * @param acceptType the acceptType to set
     */
    public void setAcceptType(String acceptType) {
        this.acceptType = acceptType;
    }

    /**
     * @return the responseTransformer
     */
    public ResponseTransformer getResponseTransformer() {
        return responseTransformer;
    }

    /**
     * @param responseTransformer the responseTransformer to set
     */
    public void setResponseTransformer(ResponseTransformer responseTransformer) {
        this.responseTransformer = responseTransformer;
    }
}
