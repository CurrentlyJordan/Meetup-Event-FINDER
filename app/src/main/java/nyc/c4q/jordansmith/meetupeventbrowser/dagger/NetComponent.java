package nyc.c4q.jordansmith.meetupeventbrowser.dagger;

import javax.inject.Singleton;

import dagger.Component;
import nyc.c4q.jordansmith.meetupeventbrowser.main.MainActivity;
import nyc.c4q.jordansmith.meetupeventbrowser.meetupList.MeetupListActivity;
import nyc.c4q.jordansmith.meetupeventbrowser.meetupList.MeetupListPresenter;

/**
 * Created by c4q on 5/11/17.
 */


@Singleton
@Component(modules={NetModule.class})
public interface NetComponent {

    void inject(MeetupListPresenter presenter);



}
