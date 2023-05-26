package sbnz.integracija.example.service;

import demo.facts.Genre;
import demo.facts.User;
import demo.facts.UserType;
import dtos.RegisterDto;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.repository.GenreRepository;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.utils.EmailValidator;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final GenreRepository genreRepository;
    private final EmailValidator emailValidator;
    private final PasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User with username '"+username+"' not found!"));
        return user;
    }

    public boolean register(RegisterDto request) {
        checkUserValidity(request.getUsername(),request.getEmail());
        userRepository.save(makeUserFromRequest(request));
        return true;
    }

    private User makeUserFromRequest(RegisterDto request) {
        String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
        Set<Genre> genres = new HashSet<>();

        request.getGenres().stream().forEach(genreId ->{
            Genre genre = genreRepository.findById(genreId).orElse(null);
            if(genre != null) genres.add(genre);
        });

        return new User(request.getName(),request.getSurname(),request.getEmail(),request.getUsername(),
                encodedPassword, UserType.REGULAR, genres);
    }

    private void checkUserValidity(String username, String email) {
        if(!emailValidator.test(email)) throw new IllegalStateException("Email is not valid!");
        boolean userExists = userRepository.findUserByUsername(username).isPresent();
        if(userExists) throw new IllegalStateException("User with username '"+username+"' already exists!");
        userExists = userRepository.findUserByEmail(email).isPresent();
        if(userExists) throw new IllegalStateException("User with email '"+email+"' already exists!");
    }

    public User getByUsername(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }
}
