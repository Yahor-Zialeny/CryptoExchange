package com.example.cryptoexchange.Models;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String state;
    private String passportNumber;
    private String passportID;
    private String phoneNumber;
    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                firstName,lastName, username, passwordEncoder.encode(password),
                email, state, passportNumber, passportID, phoneNumber);
    }
}
