package entity;

import java.util.Objects;

public class Countries {

    private int country_id;
    private String country;

    public Countries( int country_id, String country ) {
        this.country_id = country_id;
        this.country = country;
    }

    public Countries() {
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id( int country_id ) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countries countries = (Countries) o;
        return country_id == countries.country_id && Objects.equals(country, countries.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country_id, country);
    }

    @Override
    public String toString() {
        return "Countries{" +
                "country_id=" + country_id +
                ", country='" + country + '\'' +
                '}';
    }
}
