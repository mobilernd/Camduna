package com.camunda;

public class UserDTO {

    private int id;
    private String email;
    private String first_name ;
    private String last_name ;
    public String avatar ;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_Name() {
        return first_name ;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getLast_name () {
        return last_name ;
    }

    public void setLast_name (String lastName) {
        this.last_name  = lastName;
    }

    @Override
    public String toString() {
        return "Users Names {" +
                "first name is '" + first_name + '\'' +
                ", last name is '" + last_name + '\'' +
                '}';
    }
}
