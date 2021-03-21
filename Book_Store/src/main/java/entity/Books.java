package entity;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Books {
    private int book_id;
    private int author_id;
    private int publishing_house_id;
    private String book_genre;
    private Date year_of_publishing;
    private BigDecimal book_price;
    private String book_title;
    private String book_ISBN;
    private boolean book_hide;
    private int count_of_pages;

    public Books( int book_id, int author_id, int publishing_house_id, String book_genre, Date year_of_publishing, BigDecimal book_price, String book_title, String book_ISBN, boolean book_hide, int count_of_pages ) {
        this.book_id = book_id;
        this.author_id = author_id;
        this.publishing_house_id = publishing_house_id;
        this.book_genre = book_genre;
        this.year_of_publishing = year_of_publishing;
        this.book_price = book_price;
        this.book_title = book_title;
        this.book_ISBN = book_ISBN;
        this.book_hide = book_hide;
        this.count_of_pages = count_of_pages;
    }

    public Books(){
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id( int book_id ) {
        this.book_id = book_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id( int author_id ) {
        this.author_id = author_id;
    }

    public int getPublishing_house_id() {
        return publishing_house_id;
    }

    public void setPublishing_house_id( int publishing_house_id ) {
        this.publishing_house_id = publishing_house_id;
    }

    public String getBook_genre() {
        return book_genre;
    }

    public void setBook_genre( String book_genre ) {
        this.book_genre = book_genre;
    }

    public Date getYear_of_publishing() {
        return year_of_publishing;
    }

    public void setYear_of_publishing( Date year_of_publishing ) {
        this.year_of_publishing = year_of_publishing;
    }

    public BigDecimal getBook_price() {
        return book_price;
    }

    public void setBook_price( BigDecimal book_price ) {
        this.book_price = book_price;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title( String book_title ) {
        this.book_title = book_title;
    }

    public String getBook_ISBN() {
        return book_ISBN;
    }

    public void setBook_ISBN( String book_ISBN ) {
        this.book_ISBN = book_ISBN;
    }

    public boolean isBook_hide() {
        return book_hide;
    }

    public void setBook_hide( boolean book_hide ) {
        this.book_hide = book_hide;
    }

    public int getCount_of_pages() {
        return count_of_pages;
    }

    public void setCount_of_pages( int count_of_pages ) {
        this.count_of_pages = count_of_pages;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", author_id=" + author_id +
                ", publishing_house_id=" + publishing_house_id +
                ", book_genre='" + book_genre + '\'' +
                ", year_of_publishing=" + year_of_publishing +
                ", book_price=" + book_price +
                ", book_title='" + book_title + '\'' +
                ", book_ISBN=" + book_ISBN +
                ", book_hide=" + book_hide +
                ", count_of_pages=" + count_of_pages +
                '}';
    }
}
