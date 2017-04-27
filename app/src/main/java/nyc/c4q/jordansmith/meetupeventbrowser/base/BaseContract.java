package nyc.c4q.jordansmith.meetupeventbrowser.base;

/**
 * Created by jordansmith on 4/25/17.
 */

public class BaseContract {

    public interface Presenter<T>{
        void attach(T view);

        void detach();

    }

}
