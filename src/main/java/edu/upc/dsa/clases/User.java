package edu.upc.dsa.clases;

public class User {
    public String user;
    public int id;

    public User(String user, int id){
        this.user = user;
        this.id = id;
    }
    public User(){}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
