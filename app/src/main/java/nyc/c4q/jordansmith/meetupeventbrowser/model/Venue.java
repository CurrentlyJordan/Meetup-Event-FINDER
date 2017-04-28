package nyc.c4q.jordansmith.meetupeventbrowser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by c4q on 4/27/17.
 */
@Parcel
public class Venue {

    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("localized_country_name")
    @Expose
    public String localizedCountryName;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("address_1")
    @Expose
    public String address1;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("lon")
    @Expose
    public Float lon;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("lat")
    @Expose
    public Float lat;
    @SerializedName("repinned")
    @Expose
    public Boolean repinned;
    @SerializedName("zip")
    @Expose
    public String zip;
    @SerializedName("state")
    @Expose
    public String state;

    public Venue(){

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocalizedCountryName() {
        return localizedCountryName;
    }

    public void setLocalizedCountryName(String localizedCountryName) {
        this.localizedCountryName = localizedCountryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Boolean getRepinned() {
        return repinned;
    }

    public void setRepinned(Boolean repinned) {
        this.repinned = repinned;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
