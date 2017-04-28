package nyc.c4q.jordansmith.meetupeventbrowser.detail;

import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;

/**
 * Created by c4q on 4/27/17.
 */

public class DetailContract {

    interface View {

        void showGroupPhoto();

        void showVenueInfo();

        void setNameAndDescription();

        void hideGroupPhoto();

        void hideVenueInfo();

    }

    interface Presenter {
        void setResult(Result result);

        void evaluateVenueInfo();

        void evaluateGroupPhoto();


    }
}
