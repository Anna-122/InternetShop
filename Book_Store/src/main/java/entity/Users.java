package entity;

import java.util.Calendar;


public class Users {
    private int user_id;
    private String user_name;
    private String user_surname;
    private String user_middle_name;
    private String user_sex;
    private String user_email;
    private String user_username;
    private String user_password;
    private String user_birthday;
    private int user_country_id;
    private int user_city_id;
    private String user_street;
    private String user_house_number;
    private String user_flat_number;
    private int user_type_id;

    public Users(int user_id, String user_name, String user_surname, String user_middle_name, String user_sex, String user_email, String user_username, String user_password, String user_birthday, int user_country_id, int user_city_id, String user_street, String user_house_number, String user_flat_number, int user_type_id) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_middle_name = user_middle_name;
        this.user_sex = user_sex;
        this.user_email = user_email;
        this.user_username = user_username;
        this.user_password = user_password;
        this.user_birthday = user_birthday;
        this.user_country_id = user_country_id;
        this.user_city_id = user_city_id;
        this.user_street = user_street;
        this.user_house_number = user_house_number;
        this.user_flat_number = user_flat_number;
        this.user_type_id = user_type_id;
    }

    public Users (){

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getUser_middle_name() {
        return user_middle_name;
    }

    public void setUser_middle_name(String user_middle_name) {
        this.user_middle_name = user_middle_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public int getUser_country_id() {
        return user_country_id;
    }

    public void setUser_country_id(int user_country_id) {
        this.user_country_id = user_country_id;
    }

    public int getUser_city_id() {
        return user_city_id;
    }

    public void setUser_city_id(int user_city_id) {
        this.user_city_id = user_city_id;
    }

    public String getUser_street() {
        return user_street;
    }

    public void setUser_street(String user_street) {
        this.user_street = user_street;
    }

    public String getUser_house_number() {
        return user_house_number;
    }

    public void setUser_house_number(String user_house_number) {
        this.user_house_number = user_house_number;
    }

    public String getUser_flat_number() {
        return user_flat_number;
    }

    public void setUser_flat_number(String user_flat_number) {
        this.user_flat_number = user_flat_number;
    }

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(int user_type_id) {
        this.user_type_id = user_type_id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_surname='" + user_surname + '\'' +
                ", user_middle_name='" + user_middle_name + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_username='" + user_username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_birthday='" + user_birthday + '\'' +
                ", user_country_id=" + user_country_id +
                ", user_city_id=" + user_city_id +
                ", user_street='" + user_street + '\'' +
                ", user_house_number='" + user_house_number + '\'' +
                ", user_flat_number='" + user_flat_number + '\'' +
                ", user_type_id=" + user_type_id +
                '}';
    }
}