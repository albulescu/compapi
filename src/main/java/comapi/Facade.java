package comapi;

import comapi.routing.FacadeRouter;

public abstract class Facade implements DiAware {

    private Di di;
    
    /**
     * Initialize api facade
     */
    public abstract void init( FacadeRouter router );

    /* (non-Javadoc)
     * @see comapi.DiAware#setDi(comapi.Di)
     */
    @Override
    public void setDi(Di di) {
        this.di = di;
    }

    /* (non-Javadoc)
     * @see comapi.DiAware#getDi()
     */
    @Override
    public Di getDi() {
        return di;
    }
}
