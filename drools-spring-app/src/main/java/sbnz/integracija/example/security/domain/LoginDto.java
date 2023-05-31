package sbnz.integracija.example.security.domain;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}
