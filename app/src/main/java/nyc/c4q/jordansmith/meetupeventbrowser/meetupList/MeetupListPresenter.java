package nyc.c4q.jordansmith.meetupeventbrowser.meetupList;

import android.util.Log;

import java.util.List;

import nyc.c4q.jordansmith.meetupeventbrowser.base.BasePresenter;
import nyc.c4q.jordansmith.meetupeventbrowser.model.MeetupResponse;
import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;
import nyc.c4q.jordansmith.meetupeventbrowser.util.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jordansmith on 4/26/17.
 */

public class MeetupListPresenter extends BasePresenter<MeetupListContract.View> implements MeetupListContract.Presenter {

    private final static String BASE_URL =  "https://api.meetup.com";
    private final static String API_KEY = "2e1a5520269b50d3513925276236";
    List<Result> resultList;

    public MeetupListPresenter(MeetupListContract.View view) {
        super(view);
    }


    @Override
    public void fetchMeetupData() {
        view.showProgressBar(true);
        MeetupService meetupService = RetrofitHelper.getRetrofit(BASE_URL, MeetupService.class);
        Call<MeetupResponse> meetupResponse = meetupService.getMeetupList("true","public","11105","group_photo","20","0",API_KEY);
        meetupResponse.enqueue(new Callback<MeetupResponse>() {
            @Override
            public void onResponse(Call<MeetupResponse> call, Response<MeetupResponse> response) {
                Log.d("success",response.toString());
                view.showProgressBar(false);
                resultList = response.body().getResults();
            }

            @Override
            public void onFailure(Call<MeetupResponse> call, Throwable t) {
                Log.d("failure",t.toString());

            }
        });

    }
}
