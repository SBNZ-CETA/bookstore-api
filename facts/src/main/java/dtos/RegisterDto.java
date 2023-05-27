package dtos;

import java.util.List;

import lombok.Data;

@Data
public class RegisterDto {
    private final String name;
    private final String surname;
    private final String username;
    private final String password;
    private final String email;
    private final List<Long> genres;
}
