package com._concept.Gobank.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Register {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    private String phone;

    private String address;

    @Size(min = 6, message = "Minimum Password length is 6 characters")
    private String password;

    private String confirmPassword;



}
