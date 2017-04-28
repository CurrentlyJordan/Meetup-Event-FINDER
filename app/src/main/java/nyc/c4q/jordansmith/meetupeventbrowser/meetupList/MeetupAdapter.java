package nyc.c4q.jordansmith.meetupeventbrowser.meetupList;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import nyc.c4q.jordansmith.meetupeventbrowser.R;
import nyc.c4q.jordansmith.meetupeventbrowser.detail.DetailActivity;
import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;

/**
 * Created by c4q on 4/27/17.
 */

public class MeetupAdapter extends RecyclerView.Adapter<MeetupAdapter.MeetupViewHolder> {
    MeetupListPresenter presenter;
    private static final String RESULT_CODE_KEY = "Result";

    MeetupAdapter(MeetupListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public MeetupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.meetup_item_view, parent, false);
        return new MeetupViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(MeetupViewHolder holder, int position) {
        holder.bind(presenter.getResultList().get(position));

    }

    @Override
    public int getItemCount() {
        return presenter.getResultList().size();
    }


    public class MeetupViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name_event_textview)
        TextView nameTextView;
        @BindView(R.id.event_imageview)
        ImageView groupImageView;
        @BindView(R.id.location_date_textview)
        TextView dateTextView;


        public MeetupViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void bind(final Result result) {
            nameTextView.setText(result.getName());
            if (presenter.checkPhotoData(result)) {
                Glide.with(itemView.getContext()).load(result.getGroup()
                        .getGroupPhoto()
                        .getPhotoLink())
                        .into(groupImageView);
            } else {
                Glide.with(itemView.getContext()).load(R.drawable.no_image_available)
                        .into(groupImageView);

            }
            if (presenter.checkVenueData(result)) {
                String venueInfo = presenter.formatVenueInfo(result.getVenue());
                dateTextView.setText(venueInfo);
            } else {
                dateTextView.setText("No venue information available");
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra(RESULT_CODE_KEY, Parcels.wrap(result));
                    itemView.getContext().startActivity(intent);

                }
            });

        }


    }
}
