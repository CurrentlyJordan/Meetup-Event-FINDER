package nyc.c4q.jordansmith.meetupeventbrowser.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.jordansmith.meetupeventbrowser.R;
import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {
    DetailPresenter detailPresenter;
    Result result;
    private static final String RESULT_CODE_KEY = "Result";
    @BindView(R.id.meetup_detail_name_text_view)
    TextView detailNameTextView;
    @BindView(R.id.meetup_detail_image_text_view)
    ImageView detailphotoImageView;
    @BindView(R.id.meetup_detail_description_web_view)
    WebView detailWebView;
    @BindView(R.id.meetup_detail_venue_text_view)
    TextView detailVenueTextView;
    @BindView(R.id.meetup_detail_address_text_view)
    TextView detailAddressTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        detailPresenter = new DetailPresenter(this);
        Intent intent = getIntent();
        result = (Result) Parcels.unwrap(intent.getParcelableExtra(RESULT_CODE_KEY));
        detailPresenter.setResult(result);
        setNameAndDescription();
        detailPresenter.evaluateGroupPhoto();
        detailPresenter.evaluateVenueInfo();
    }



    @Override
    public void showGroupPhoto() {
        Glide.with(this).load(result.getGroup()
                .getGroupPhoto()
                .getPhotoLink())
                .into(detailphotoImageView);

    }

    @Override
    public void showVenueInfo() {
        detailVenueTextView.setText(result.getVenue().getName());
        detailAddressTextView.setText(result.getVenue().getAddress1());
    }

    @Override
    public void setNameAndDescription() {
        detailNameTextView.setText(result.getName());
        detailWebView.loadData(result.getDescription(),"text/html", null);
    }

    @Override
    public void hideGroupPhoto() {
        detailphotoImageView.setVisibility(View.GONE);
    }

    @Override
    public void hideVenueInfo() {
        detailVenueTextView.setVisibility(View.GONE);

    }

    @Override
    protected void onDestroy() {
        detailPresenter.detach();
        super.onDestroy();
    }
}
