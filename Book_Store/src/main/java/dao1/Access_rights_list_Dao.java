package dao1;

import entity.Access_rights_list;

import java.sql.SQLException;
import java.util.List;

public interface Access_rights_list_Dao {

    //create
    void add( Access_rights_list access_rights_list) throws SQLException;

    //read
    List<Access_rights_list> getAll() throws SQLException;

    Access_rights_list getById( Integer id) throws SQLException;

    //update
    void update( Access_rights_list access_rights_list) throws SQLException;

    //delete
    void remove( Access_rights_list access_rights_list) throws SQLException;
}
