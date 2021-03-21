package entity;

import java.util.Objects;

public class Cities {

    private int city_id;
    private int country_id;
    private String city;

    public Cities( int city_id, int country_id, String city ) {
        this.city_id = city_id;
        this.country_id = country_id;
        this.city = city;
    }
    public Cities(){

    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id( int city_id ) {
        this.city_id = city_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id( int country_id ) {
        this.country_id = country_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "city_id=" + city_id +
                ", country_id=" + country_id +
                ", city='" + city + '\'' +
                '}';
    }
}

