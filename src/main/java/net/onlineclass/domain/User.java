package net.onlineclass.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

    private int id;

    private String username;


//    @JsonIgnore
    private String pwd; //JSON序列化配置 忽略当前字段

    public User(){

    }

    public User(int id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
