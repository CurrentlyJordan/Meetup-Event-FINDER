package nyc.c4q.jordansmith.meetupeventbrowser.model;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by jordansmith on 4/26/17.
 */
@Parcel
public class MeetupResponse {
    public List<Result> results;
    public Meta meta;

    public MeetupResponse() {

    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
