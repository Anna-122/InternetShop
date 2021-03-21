package dao1;

import entity.Registered_User_Role;

import java.sql.SQLException;
import java.util.List;

public interface Registered_User_RoleDao {
    //create
    void add( Registered_User_Role role) throws SQLException;

    //read
    List<Registered_User_Role> getAll() throws SQLException;

    Registered_User_Role getById( Integer id) throws SQLException;

    //update
    void update( Registered_User_Role role) throws SQLException;

    //delete
    void remove( Registered_User_Role role) throws SQLException;
}