package com.project.cattycat.application.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class RegisterRequestDTO implements Serializable {

    @Email(message = "Please enter valid email")
    @NotBlank(message = "Email cannot be blank")
    String email;
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 4, message = "Password must be greater than 4")
    String password;
    @NotBlank(message = "RePassword cannot be blank")
    @Size(min = 4, message = "Password must be greater than 4")
    String rePassword;

    @AssertTrue(message = "Passwords does not match!")
    public boolean isPasswordMatching() {
        return password != null && password.equals(rePassword);
    }
}
