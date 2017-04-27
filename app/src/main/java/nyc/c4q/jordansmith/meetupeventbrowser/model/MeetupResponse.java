package nyc.c4q.jordansmith.meetupeventbrowser.model;

import java.util.List;

/**
 * Created by jordansmith on 4/26/17.
 */

public class MeetupResponse {
    private List<Result> results;
    private Meta meta;

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
