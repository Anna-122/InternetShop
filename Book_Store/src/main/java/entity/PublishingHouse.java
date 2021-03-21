package entity;

import java.util.Objects;

public class PublishingHouse {

    private int publishing_house_id;
    private String publishing_house_name;
    private int publishing_house_phone_number;
    private int publishing_house_country_id;
    private int publishing_house_city_id;
    private String publishing_house_street;
    private String publishing_house_number;
    private String publishing_flat_number;
    private int publishing_house_postcode;

    public PublishingHouse( int publishing_house_id, String publishing_house_name, int publishing_house_phone_number, int publishing_house_country_id, int publishing_house_city_id, String publishing_house_street, String publishing_house_number, String publishing_flat_number, int publishing_house_postcode ) {
        this.publishing_house_id = publishing_house_id;
        this.publishing_house_name = publishing_house_name;
        this.publishing_house_phone_number = publishing_house_phone_number;
        this.publishing_house_country_id = publishing_house_country_id;
        this.publishing_house_city_id = publishing_house_city_id;
        this.publishing_house_street = publishing_house_street;
        this.publishing_house_number = publishing_house_number;
        this.publishing_flat_number = publishing_flat_number;
        this.publishing_house_postcode = publishing_house_postcode;
    }

    public PublishingHouse(){
    }

    public int getPublishing_house_id() {
        return publishing_house_id;
    }

    public void setPublishing_house_id( int publishing_house_id ) {
        this.publishing_house_id = publishing_house_id;
    }

    public String getPublishing_house_name() {
        return publishing_house_name;
    }

    public void setPublishing_house_name( String publishing_house_name ) {
        this.publishing_house_name = publishing_house_name;
    }

    public int getPublishing_house_phone_number() {
        return publishing_house_phone_number;
    }

    public void setPublishing_house_phone_number( int publishing_house_phone_number ) {
        this.publishing_house_phone_number = publishing_house_phone_number;
    }

    public int getPublishing_house_country_id() {
        return publishing_house_country_id;
    }

    public void setPublishing_house_country_id( int publishing_house_country_id ) {
        this.publishing_house_country_id = publishing_house_country_id;
    }

    public int getPublishing_house_city_id() {
        return publishing_house_city_id;
    }

    public void setPublishing_house_city_id( int publishing_house_city_id ) {
        this.publishing_house_city_id = publishing_house_city_id;
    }

    public String getPublishing_house_street() {
        return publishing_house_street;
    }

    public void setPublishing_house_street( String publishing_house_street ) {
        this.publishing_house_street = publishing_house_street;
    }

    public String getPublishing_house_number() {
        return publishing_house_number;
    }

    public void setPublishing_house_number( String publishing_house_number ) {
        this.publishing_house_number = publishing_house_number;
    }

    public String getPublishing_flat_number() {
        return publishing_flat_number;
    }

    public void setPublishing_flat_number( String publishing_flat_number ) {
        this.publishing_flat_number = publishing_flat_number;
    }

    public int getPublishing_house_postcode() {
        return publishing_house_postcode;
    }

    public void setPublishing_house_postcode( int publishing_house_postcode ) {
        this.publishing_house_postcode = publishing_house_postcode;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishingHouse that = (PublishingHouse) o;
        return publishing_house_id == that.publishing_house_id && publishing_house_phone_number == that.publishing_house_phone_number && publishing_house_country_id == that.publishing_house_country_id && publishing_house_city_id == that.publishing_house_city_id && publishing_house_number == that.publishing_house_number && publishing_flat_number == that.publishing_flat_number && publishing_house_postcode == that.publishing_house_postcode && Objects.equals(publishing_house_name, that.publishing_house_name) && Objects.equals(publishing_house_street, that.publishing_house_street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishing_house_id, publishing_house_name, publishing_house_phone_number, publishing_house_country_id, publishing_house_city_id, publishing_house_street, publishing_house_number, publishing_flat_number, publishing_house_postcode);
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "publishing_house_id=" + publishing_house_id +
                ", publishing_house_name='" + publishing_house_name + '\'' +
                ", publishing_house_phone_number=" + publishing_house_phone_number +
                ", publishing_house_country_id=" + publishing_house_country_id +
                ", publishing_house_city_id=" + publishing_house_city_id +
                ", publishing_house_street='" + publishing_house_street + '\'' +
                ", publishing_house_number=" + publishing_house_number +
                ", publishing_flat_number=" + publishing_flat_number +
                ", publishing_house_postcode=" + publishing_house_postcode +
                '}';
    }
}
