package nyc.c4q.jordansmith.meetupeventbrowser.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.jordansmith.meetupeventbrowser.R;
import nyc.c4q.jordansmith.meetupeventbrowser.meetupList.MeetupListActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    @BindView(R.id.zipcode_edit_text) EditText zipCodeEditText;
    @BindView(R.id.use_location_button) Button useLocationButton;
    private MainPresenter mainPresenter;
    private static final String LOCATION_ZIP_CODE_KEY= "zipCode";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);

        zipCodeEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    onZipCodeEntered();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void openDetailActivity(String zipCode) {
        Intent intent = new Intent(this, MeetupListActivity.class);
        intent.putExtra(LOCATION_ZIP_CODE_KEY, zipCode);
        startActivity(intent);
    }

    @Override
    public void onZipCodeEntered() {
        String enteredZipCode = zipCodeEditText.getText().toString();
        mainPresenter.evaluateZipCode(enteredZipCode);
    }

    @Override
    public void showLengthErrorMessage() {
        Toast.makeText(this,"Zip code needs to be 5 digits", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.detach();
        super.onDestroy();
    }
}
