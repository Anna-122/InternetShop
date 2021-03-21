package entity;

import java.math.BigDecimal;
import java.util.Date;

public class Purchase {
    private int purchase_id;
    private int book_id;
    private int user_id;
    private Date purchase_adding;
    private Date purchase_deleting;
    private int book_count;
    private BigDecimal book_price;
    private boolean book_deleted;
    private boolean book_paid;

    public Purchase( int purchase_id, int book_id, int user_id, Date purchase_adding, Date purchase_deleting, int book_count, BigDecimal book_price, boolean book_deleted, boolean book_paid ) {
        this.purchase_id = purchase_id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.purchase_adding = purchase_adding;
        this.purchase_deleting = purchase_deleting;
        this.book_count = book_count;
        this.book_price = book_price;
        this.book_deleted = book_deleted;
        this.book_paid = book_paid;
    }

    public Purchase(){

    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id( int purchase_id ) {
        this.purchase_id = purchase_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id( int book_id ) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id( int user_id ) {
        this.user_id = user_id;
    }

    public Date getPurchase_adding() {
        return purchase_adding;
    }

    public void setPurchase_adding( Date purchase_adding ) {
        this.purchase_adding = purchase_adding;
    }

    public Date getPurchase_deleting() {
        return purchase_deleting;
    }

    public void setPurchase_deleting( Date purchase_deleting ) {
        this.purchase_deleting = purchase_deleting;
    }

    public int getBook_count() {
        return book_count;
    }

    public void setBook_count( int book_count ) {
        this.book_count = book_count;
    }

    public BigDecimal getBook_price() {
        return book_price;
    }

    public void setBook_price( BigDecimal book_price ) {
        this.book_price = book_price;
    }

    public boolean isBook_deleted() {
        return book_deleted;
    }

    public void setBook_deleted( boolean book_deleted ) {
        this.book_deleted = book_deleted;
    }

    public boolean isBook_paid() {
        return book_paid;
    }

    public void setBook_paid( boolean book_paid ) {
        this.book_paid = book_paid;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchase_id=" + purchase_id +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                ", purchase_adding=" + purchase_adding +
                ", purchase_deleting=" + purchase_deleting +
                ", book_count=" + book_count +
                ", book_price=" + book_price +
                ", book_deleted=" + book_deleted +
                ", book_paid=" + book_paid +
                '}';
    }
}
