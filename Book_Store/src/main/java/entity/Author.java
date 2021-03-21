package entity;


import java.util.Date;
import java.util.Objects;

public class Author {

    private int author_id;
    private String author_name;
    private String author_surname;
    private String author_middle_name;
    private Date author_birthday_date;

    public Author( int author_id, String author_name, String author_surname, String author_middle_name, Date author_birthday_date ) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_surname = author_surname;
        this.author_middle_name = author_middle_name;
        this.author_birthday_date = author_birthday_date;
    }
    public Author(){

    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id( int author_id ) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name( String author_name ) {
        this.author_name = author_name;
    }

    public String getAuthor_surname() {
        return author_surname;
    }

    public void setAuthor_surname( String author_surname ) {
        this.author_surname = author_surname;
    }

    public String getAuthor_middle_name() {
        return author_middle_name;
    }

    public void setAuthor_middle_name( String author_middle_name ) {
        this.author_middle_name = author_middle_name;
    }

    public Date getAuthor_birthday_date() {
        return author_birthday_date;
    }

    public void setAuthor_birthday_date( Date author_birthday_date ) {
        this.author_birthday_date = author_birthday_date;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return author_id == author.author_id && Objects.equals(author_name, author.author_name) && Objects.equals(author_surname, author.author_surname) && Objects.equals(author_middle_name, author.author_middle_name) && Objects.equals(author_birthday_date, author.author_birthday_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author_id, author_name, author_surname, author_middle_name, author_birthday_date);
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", author_surname='" + author_surname + '\'' +
                ", author_middle_name='" + author_middle_name + '\'' +
                ", author_birthday_date=" + author_birthday_date +
                '}';
    }
}
