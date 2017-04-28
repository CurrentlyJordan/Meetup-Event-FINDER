package nyc.c4q.jordansmith.meetupeventbrowser.model;

import org.parceler.Parcel;

/**
 * Created by jordansmith on 4/26/17.
 */
@Parcel
public class Fee {
    public Integer amount;
    public String accepts;
    public String description;
    public String currency;
    public String label;
    public String required;

    public Fee(){

    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAccepts() {
        return accepts;
    }

    public void setAccepts(String accepts) {
        this.accepts = accepts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
