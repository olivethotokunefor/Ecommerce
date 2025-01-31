package com.example.Ecommerce.Models;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName =  "user_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private int id;

    private String firstname;
    private String lastname;
    private String password;
    private String email;

    private String role;


    public User() {
    }

    public User(String firstname, String lastname, String password, String email, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;

        this.role=role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
