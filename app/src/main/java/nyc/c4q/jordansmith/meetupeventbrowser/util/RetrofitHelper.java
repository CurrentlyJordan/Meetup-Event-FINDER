package nyc.c4q.jordansmith.meetupeventbrowser.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jordansmith on 4/25/17.
 */

public class  RetrofitHelper {

    public static <T> T getRetrofit(String baseUrl, Class<T> service){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }
}