package nyc.c4q.jordansmith.meetupeventbrowser.detail;


import nyc.c4q.jordansmith.meetupeventbrowser.base.BasePresenter;
import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;
import nyc.c4q.jordansmith.meetupeventbrowser.util.ResultHelper;


/**
 * Created by c4q on 4/27/17.
 */

public class DetailPresenter extends BasePresenter<DetailContract.View> implements DetailContract.Presenter {
    private Result result;

    DetailPresenter(DetailContract.View view) {
        super(view);
    }


    @Override
    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public void evaluateVenueInfo() {
        if (ResultHelper.checkVenueData(result)) {
            view.showVenueInfo();
        } else {
            view.hideVenueInfo();
        }
    }

    @Override
    public void evaluateGroupPhoto() {
        if (ResultHelper.checkPhotoData(result)) {
            view.showGroupPhoto();
        } else {
            view.hideGroupPhoto();
        }

    }
}
