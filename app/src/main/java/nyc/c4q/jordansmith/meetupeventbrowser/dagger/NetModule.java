package nyc.c4q.jordansmith.meetupeventbrowser.dagger;


import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by c4q on 5/11/17.
 */
@Module
public class NetModule {

    @Provides @Named("meetup")
    @Singleton
    Retrofit providesRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.meetup.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


}
