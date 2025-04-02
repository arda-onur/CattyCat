package com.project.cattycat.domain.user;

public class User {
    private final UserId id;
    private final String email;
    private final String password;
    private final Address address;
    private final Role role;

    public User(final UserId id, final String email, final String password) {
        if (email.isBlank() || password.isBlank())
            throw new IllegalArgumentException("Email or password cannot be blank.");
        if (id == null)
            throw new NullPointerException("id is null");

        this.id = id;
        this.email = email;
        this.password = password;
        this.address = null;
        this.role = Role.USER;
    }

    public UserId getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }
}
