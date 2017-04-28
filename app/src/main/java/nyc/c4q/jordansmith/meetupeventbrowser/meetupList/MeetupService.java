package nyc.c4q.jordansmith.meetupeventbrowser.meetupList;

import nyc.c4q.jordansmith.meetupeventbrowser.model.MeetupResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jordansmith on 4/26/17.
 */

public interface MeetupService {
    // https://api.meetup.com/2/open_events?&sign=true&photo-host=public&zip=11222&fields=group_photo&page=20&offset=0&key=%7BYOUR_KEY

    @GET("/2/open_events")
    Call<MeetupResponse> getMeetupList(@Query("sign") String sign,
                                       @Query("photo-host") String photoHost,
                                       @Query("zip") String zip,
                                       @Query("fields") String fields,
                                       @Query("page") String page,
                                       @Query("offset") String offset,
                                       @Query("key") String key);
}
