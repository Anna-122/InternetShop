package dao1;

import entity.Purchase;

import java.sql.SQLException;
import java.util.List;

public interface PurchaseDao {

    //create
    void add( Purchase purchase) throws SQLException;

    //read
    List<Purchase> getAll() throws SQLException;

    Purchase getById( Integer id) throws SQLException;

    //update
    void update( Purchase purchase) throws SQLException;

    //delete
    void remove( Purchase purchase) throws SQLException;
}
