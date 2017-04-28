package nyc.c4q.jordansmith.meetupeventbrowser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by jordansmith on 4/26/17.
 */
@Parcel
public class Group {


    @SerializedName("join_mode")
    @Expose
    public String joinMode;
    @SerializedName("created")
    @Expose
    public Long created;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("group_lon")
    @Expose
    public Float groupLon;
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("urlname")
    @Expose
    public String urlname;
    @SerializedName("group_photo")
    @Expose
    public GroupPhoto groupPhoto;
    @SerializedName("group_lat")
    @Expose
    public Float groupLat;
    @SerializedName("who")
    @Expose
    public String who;

    public Group() {

    }

    public String getJoinMode() {
        return joinMode;
    }

    public void setJoinMode(String joinMode) {
        this.joinMode = joinMode;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getGroupLon() {
        return groupLon;
    }

    public void setGroupLon(Float groupLon) {
        this.groupLon = groupLon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public GroupPhoto getGroupPhoto() {
        return groupPhoto;
    }

    public void setGroupPhoto(GroupPhoto groupPhoto) {
        this.groupPhoto = groupPhoto;
    }

    public Float getGroupLat() {
        return groupLat;
    }

    public void setGroupLat(Float groupLat) {
        this.groupLat = groupLat;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
