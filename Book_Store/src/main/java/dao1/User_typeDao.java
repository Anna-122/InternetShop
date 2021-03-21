package dao1;

import entity.User_type;
import java.sql.SQLException;
import java.util.List;

public interface User_typeDao {

    //create
    void add( User_type user_type) throws SQLException;

    //read
    List<User_type> getAll() throws SQLException;

    User_type getById( Integer id) throws SQLException;

    //update
    void update( User_type user_type) throws SQLException;

    //delete
    void remove( User_type user_type) throws SQLException;

}



