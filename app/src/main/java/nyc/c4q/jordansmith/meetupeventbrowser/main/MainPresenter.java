package nyc.c4q.jordansmith.meetupeventbrowser.main;

import nyc.c4q.jordansmith.meetupeventbrowser.base.BasePresenter;

/**
 * Created by jordansmith on 4/25/17.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {


    public MainPresenter(MainContract.View view) {
        super(view);
    }


    @Override
    public void evaluateZipCode(String zipCode) {
        if (zipCode.length() != 5) {
            view.showLengthErrorMessage();
        } else {
            view.openDetailActivity(zipCode);
        }

    }
}
