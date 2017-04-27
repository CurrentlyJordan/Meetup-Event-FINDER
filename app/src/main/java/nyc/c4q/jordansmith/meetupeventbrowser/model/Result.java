package nyc.c4q.jordansmith.meetupeventbrowser.model;

/**
 * Created by jordansmith on 4/26/17.
 */

public class Result {
    private Long utcOffset;
    private Long rsvpLimit;
    private Long headcount;
    private Float distance;
    private String visibility;
    private Long waitlistCount;
    private Long created;
    private Fee fee;
    private Long maybeRsvpCount;
    private String description;
    private String eventUrl;
    private Long yesRsvpCount;
    private Long duration;
    private String name;
    private String id;
    private Long time;
    private Long updated;
    private Group group;
    private String status;

    public Long getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Long utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Long getRsvpLimit() {
        return rsvpLimit;
    }

    public void setRsvpLimit(Long rsvpLimit) {
        this.rsvpLimit = rsvpLimit;
    }

    public Long getHeadcount() {
        return headcount;
    }

    public void setHeadcount(Long headcount) {
        this.headcount = headcount;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Long getWaitlistCount() {
        return waitlistCount;
    }

    public void setWaitlistCount(Long waitlistCount) {
        this.waitlistCount = waitlistCount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Long getMaybeRsvpCount() {
        return maybeRsvpCount;
    }

    public void setMaybeRsvpCount(Long maybeRsvpCount) {
        this.maybeRsvpCount = maybeRsvpCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public Long getYesRsvpCount() {
        return yesRsvpCount;
    }

    public void setYesRsvpCount(Long yesRsvpCount) {
        this.yesRsvpCount = yesRsvpCount;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
