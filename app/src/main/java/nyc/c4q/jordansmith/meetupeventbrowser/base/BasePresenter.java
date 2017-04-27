package nyc.c4q.jordansmith.meetupeventbrowser.base;

/**
 * Created by jordansmith on 4/25/17.
 */

public class BasePresenter <T> implements BaseContract.Presenter<T>{
    public T view;

    public BasePresenter(T view){
        attach(view);
    }

    @Override
    public void attach(T view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;

    }
}
