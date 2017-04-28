package nyc.c4q.jordansmith.meetupeventbrowser.meetupList;

import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;
import nyc.c4q.jordansmith.meetupeventbrowser.model.Venue;

/**
 * Created by jordansmith on 4/26/17.
 */

public interface MeetupListContract {

    interface View {
        void showProgressBar(boolean show);

        void displayMeetupData(List<Result> resultList);

        void showNoMeetupPage();

        void showErrorMeetupPage();




    }

    interface Presenter {
        void fetchMeetupData(String zipCode);

        void evaluateMeetupData(String zipCode);

        String formatMessage(String zipCode);

        List<Result> getResultList();

        boolean checkPhotoData(Result result);

        boolean checkVenueData(Result result);

        String formatVenueInfo(Venue venue);

        ArrayList<Parcelable> convertResultsToParcelable();

        void convertParcelableToResults(ArrayList<Parcelable> parcelables);

        boolean checkResults();


    }
}
