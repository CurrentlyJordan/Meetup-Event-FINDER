package nyc.c4q.jordansmith.meetupeventbrowser.meetupList;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.jordansmith.meetupeventbrowser.R;
import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;

public class MeetupListActivity extends AppCompatActivity implements MeetupListContract.View {
    private MeetupListPresenter meetupListPresenter;
    @BindView(R.id.meetup_recyclerview)
    RecyclerView meetupRecyclerview;
    @BindView(R.id.meetup_progress)
    ProgressBar progressBar;
    @BindView(R.id.error_linear_layout)
    LinearLayout errorMeetupsLinearLayout;
    @BindView(R.id.not_meetups_linear_layout)
    LinearLayout noMeetupsLinearLayout;
    @BindView(R.id.no_meetups_zipcode_message)
    TextView noMeetupsZipcodeTextView;

    private static final String LOCATION_ZIP_CODE_KEY = "zipCode";
    private static final String PARCELABLE_LIST_KEY = "ParcelableList";
    String userZipCode;
    MeetupAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetup_list);
        ButterKnife.bind(this);
        meetupListPresenter = new MeetupListPresenter(this);
        userZipCode = getIntent().getStringExtra(LOCATION_ZIP_CODE_KEY);
        checkSaveInstanceState(savedInstanceState);

    }


    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void displayMeetupData(List<Result> resultList) {
        adapter = new MeetupAdapter(meetupListPresenter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        meetupRecyclerview.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(meetupRecyclerview.getContext(),
                layoutManager.getOrientation());
        meetupRecyclerview.addItemDecoration(dividerItemDecoration);
        meetupRecyclerview.setLayoutManager(layoutManager);
        meetupRecyclerview.setAdapter(adapter);
    }


    @Override
    public void showNoMeetupPage() {
        noMeetupsZipcodeTextView.setText(meetupListPresenter.formatMessage(userZipCode));
        noMeetupsLinearLayout.setVisibility(View.VISIBLE);


    }

    @Override
    public void showErrorMeetupPage() {
        errorMeetupsLinearLayout.setVisibility(View.VISIBLE);
    }

    void checkSaveInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            meetupListPresenter.fetchMeetupData(userZipCode);
        } else {
            if (savedInstanceState.getParcelableArray(PARCELABLE_LIST_KEY) == null) {
                meetupListPresenter.fetchMeetupData(userZipCode);
            } else {
                showProgressBar(false);
                ArrayList<Parcelable> parcelables = savedInstanceState.getParcelableArrayList(PARCELABLE_LIST_KEY);
                meetupListPresenter.convertParcelableToResults(parcelables);

            }

        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (meetupListPresenter.checkResults()) {
            outState.putParcelableArrayList(PARCELABLE_LIST_KEY, meetupListPresenter.convertResultsToParcelable());
        }
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onDestroy() {
        meetupListPresenter.detach();
        super.onDestroy();
    }
}
