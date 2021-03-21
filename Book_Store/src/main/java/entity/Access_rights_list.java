package entity;

public class Access_rights_list {
    private int user_right_id;
    private int user_type_id;
    private String rights;

    public Access_rights_list( int user_right_id, int user_type_id, String rights ) {
        this.user_right_id = user_right_id;
        this.user_type_id = user_type_id;
        this.rights = rights;
    }
    public Access_rights_list(){

    }

    public int getUser_right_id() {
        return user_right_id;
    }

    public void setUser_right_id( int user_right_id ) {
        this.user_right_id = user_right_id;
    }

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id( int user_type_id ) {
        this.user_type_id = user_type_id;
    }

    public String getRights() {
        return rights;
    }

    public void setRights( String rights ) {
        this.rights = rights;
    }

    @Override
    public String toString() {
        return "Access_rights_list{" +
                "user_right_id=" + user_right_id +
                ", user_type_id=" + user_type_id +
                ", rights='" + rights + '\'' +
                '}';
    }
}
