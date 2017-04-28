package nyc.c4q.jordansmith.meetupeventbrowser.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jordansmith on 4/25/17.
 */

public class RetrofitHelper {
    private static Retrofit.Builder Instance;

    public static <T> T getMeetupResponse(String baseUrl, Class<T> service) {
        Retrofit retrofit = getInstance()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }

    private static Retrofit.Builder getInstance() {
        if (Instance == null) {
            Instance = new Retrofit.Builder();
        }
        return Instance;
    }
}
