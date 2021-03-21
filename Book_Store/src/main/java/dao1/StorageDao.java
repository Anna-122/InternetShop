package dao1;

import entity.Storage;

import java.sql.SQLException;
import java.util.List;

public interface StorageDao {

    //create
    void add( Storage storage) throws SQLException;

    //read
    List<Storage> getAll() throws SQLException;

    Storage getById( Integer id) throws SQLException;

    //update
    void update( Storage storage) throws SQLException;

    //delete
    void remove( Storage storage) throws SQLException;
}