package entity;

public class Registered_User_Role {
    private int register_user_role_id;
    private int user_id;
    private int user_type_id;

    public Registered_User_Role( int register_user_role_id, int user_id, int user_type_id ) {
        this.register_user_role_id = register_user_role_id;
        this.user_id = user_id;
        this.user_type_id = user_type_id;
    }

    public Registered_User_Role(){

    }

    public int getRegister_user_role_id() {
        return register_user_role_id;
    }

    public void setRegister_user_role_id( int register_user_role_id ) {
        this.register_user_role_id = register_user_role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id( int user_id ) {
        this.user_id = user_id;
    }

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id( int user_type_id ) {
        this.user_type_id = user_type_id;
    }

    @Override
    public String toString() {
        return "Registered_User_Role{" +
                "register_user_role_id=" + register_user_role_id +
                ", user_id=" + user_id +
                ", user_type_id=" + user_type_id +
                '}';
    }
}
