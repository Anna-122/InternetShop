package entity;

public class Storage {
    private int storage_id;
    private int book_id;
    private int book_count;
    private int storage_country_id;
    private int storage_city_id;
    private String storage_street;
    private String storage_house_number;
    private String storage_flat_number;

    public Storage( int storage_id, int book_id, int book_count, int storage_country_id, int storage_city_id, String storage_street, String storage_house_number, String storage_flat_number ) {
        this.storage_id = storage_id;
        this.book_id = book_id;
        this.book_count = book_count;
        this.storage_country_id = storage_country_id;
        this.storage_city_id = storage_city_id;
        this.storage_street = storage_street;
        this.storage_house_number = storage_house_number;
        this.storage_flat_number = storage_flat_number;
    }
    public Storage(){

    }

    public int getStorage_id() {
        return storage_id;
    }

    public void setStorage_id( int storage_id ) {
        this.storage_id = storage_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id( int book_id ) {
        this.book_id = book_id;
    }

    public int getBook_count() {
        return book_count;
    }

    public void setBook_count( int book_count ) {
        this.book_count = book_count;
    }

    public int getStorage_country_id() {
        return storage_country_id;
    }

    public void setStorage_country_id( int storage_country_id ) {
        this.storage_country_id = storage_country_id;
    }

    public int getStorage_city_id() {
        return storage_city_id;
    }

    public void setStorage_city_id( int storage_city_id ) {
        this.storage_city_id = storage_city_id;
    }

    public String getStorage_street() {
        return storage_street;
    }

    public void setStorage_street( String storage_street ) {
        this.storage_street = storage_street;
    }

    public String getStorage_house_number() {
        return storage_house_number;
    }

    public void setStorage_house_number( String storage_house_number ) {
        this.storage_house_number = storage_house_number;
    }

    public String getStorage_flat_number() {
        return storage_flat_number;
    }

    public void setStorage_flat_number( String storage_flat_number ) {
        this.storage_flat_number = storage_flat_number;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storage_id=" + storage_id +
                ", book_id=" + book_id +
                ", book_count=" + book_count +
                ", storage_country_id=" + storage_country_id +
                ", storage_city_id=" + storage_city_id +
                ", storage_street='" + storage_street + '\'' +
                ", storage_house_number=" + storage_house_number +
                ", storage_flat_number=" + storage_flat_number +
                '}';
    }
}
