package nyc.c4q.jordansmith.meetupeventbrowser.meetupList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.jordansmith.meetupeventbrowser.R;

public class MeetupListActivity extends AppCompatActivity implements MeetupListContract.View {
    private MeetupListPresenter meetupListPresenter;
    @BindView(R.id.meetup_recyclerview) RecyclerView meetupRecyclerview;
    @BindView(R.id.meetup_progress) ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        meetupListPresenter = new MeetupListPresenter(this);
        meetupListPresenter.fetchMeetupData();


    }

    public void showProgressBar(boolean show) {
        if(show){
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
