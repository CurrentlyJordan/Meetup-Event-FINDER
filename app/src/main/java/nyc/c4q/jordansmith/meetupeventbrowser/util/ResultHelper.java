package nyc.c4q.jordansmith.meetupeventbrowser.util;

import nyc.c4q.jordansmith.meetupeventbrowser.model.Result;

/**
 * Created by c4q on 4/27/17.
 */

public class ResultHelper {


    public static boolean checkPhotoData(Result result) {
        return result.getGroup().getGroupPhoto() != null;
    }


    public static boolean checkVenueData(Result result) {
        return result.getVenue() != null;
    }
}
