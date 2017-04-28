package nyc.c4q.jordansmith.meetupeventbrowser.meetupList;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.jordansmith.meetupeventbrowser.BuildConfig;
import nyc.c4q.jordansmith.meetupeventbrowser.base.BasePresenter;
import nyc.c4q.jordansmith.meetupeventbrowser.model.MeetupResponse;
import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;
import nyc.c4q.jordansmith.meetupeventbrowser.model.Venue;
import nyc.c4q.jordansmith.meetupeventbrowser.util.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jordansmith on 4/26/17.
 */

public class MeetupListPresenter extends BasePresenter<MeetupListContract.View> implements MeetupListContract.Presenter {

    private final static String BASE_URL = "https://api.meetup.com";
    private static final String API_KEY = BuildConfig.API_KEY;
     private List<Result> resultList;

    MeetupListPresenter(MeetupListContract.View view) {
        super(view);
    }


    @Override
    public void fetchMeetupData(final String zipCode) {
        MeetupService meetupService = RetrofitHelper.getMeetupResponse(BASE_URL, MeetupService.class);
        Call<MeetupResponse> meetupResponse = meetupService.getMeetupList("true", "public", zipCode, "group_photo", "20", "0", API_KEY);
        meetupResponse.enqueue(new Callback<MeetupResponse>() {
            @Override
            public void onResponse(Call<MeetupResponse> call, Response<MeetupResponse> response) {
                Log.d("success", response.toString());
                view.showProgressBar(false);
                if (response.body() == null) {
                    view.showNoMeetupPage();
                } else {
                    resultList = response.body().getResults();
                    evaluateMeetupData(zipCode);
                }
            }

            @Override
            public void onFailure(Call<MeetupResponse> call, Throwable t) {
                Log.d("failure", t.toString());
                view.showProgressBar(false);
                view.showErrorMeetupPage();

            }
        });

    }

    @Override
    public void evaluateMeetupData(String zipCode) {
        if (resultList != null) {
            view.displayMeetupData(resultList);
        } else {
            view.showNoMeetupPage();
        }
    }

    @Override
    public String formatMessage(String zipCode) {
        StringBuilder message = new StringBuilder("No Meetups Available for ");
        message.append("\"");
        message.append(zipCode);
        message.append("\"");
        return message.toString();
    }

    @Override
    public List<Result> getResultList() {
        return resultList;
    }

    @Override
    public boolean checkPhotoData(Result result) {
        return result.getGroup().getGroupPhoto() != null;
    }

    @Override
    public boolean checkVenueData(Result result) {
        return result.getVenue() != null;
    }

    @Override
    public String formatVenueInfo(Venue venue) {
        StringBuilder venueInfo = new StringBuilder(venue.getName());
        venueInfo.append(", ");
        venueInfo.append(venue.getAddress1());
        return venueInfo.toString();
    }

    @Override
    public ArrayList<Parcelable> convertResultsToParcelable() {
        ArrayList<Parcelable> parcelableResults = new ArrayList<>();
        for (Result result : resultList) {
            Parcelable parcelable = Parcels.wrap(result);
            parcelableResults.add(parcelable);
        }
        return parcelableResults;

    }

    @Override
    public void convertParcelableToResults(ArrayList<Parcelable> parcelables) {
        List<Result> resultList = new ArrayList<>();
        for (Parcelable parcelable : parcelables) {
            Result result = Parcels.unwrap(parcelable);
            resultList.add(result);
        }
        this.resultList = resultList;
        view.displayMeetupData(resultList);
    }

    @Override
    public boolean checkResults() {
        return resultList != null;
    }

}
