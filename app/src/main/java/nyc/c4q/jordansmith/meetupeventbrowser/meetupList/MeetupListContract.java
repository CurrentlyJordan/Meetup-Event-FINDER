package nyc.c4q.jordansmith.meetupeventbrowser.meetupList;

/**
 * Created by jordansmith on 4/26/17.
 */

public interface MeetupListContract {

    interface View{
        void showProgressBar(boolean show);



    }

    interface Presenter{
        void fetchMeetupData();

    }
}
