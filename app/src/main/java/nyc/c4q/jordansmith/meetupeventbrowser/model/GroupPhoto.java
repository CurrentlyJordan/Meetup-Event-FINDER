package nyc.c4q.jordansmith.meetupeventbrowser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by jordansmith on 4/26/17.
 */
@Parcel
public class GroupPhoto {

    @SerializedName("highres_link")
    @Expose
    public String highresLink;
    @SerializedName("photo_id")
    @Expose
    public Long photoId;
    @SerializedName("base_url")
    @Expose
    public String baseUrl;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("photo_link")
    @Expose
    public String photoLink;
    @SerializedName("thumb_link")
    @Expose
    public String thumbLink;

    public GroupPhoto(){

    }

    public String getHighresLink() {
        return highresLink;
    }

    public void setHighresLink(String highresLink) {
        this.highresLink = highresLink;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getThumbLink() {
        return thumbLink;
    }

    public void setThumbLink(String thumbLink) {
        this.thumbLink = thumbLink;
    }
}
