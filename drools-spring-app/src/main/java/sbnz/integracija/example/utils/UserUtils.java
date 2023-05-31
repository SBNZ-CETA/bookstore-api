package sbnz.integracija.example.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import demo.facts.User;
import lombok.RequiredArgsConstructor;
import sbnz.integracija.example.service.UserService;

@Component
@RequiredArgsConstructor
public class UserUtils {
    private final UserService userService;

    public long getLoggedId(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        var detailUser = (User)auth.getPrincipal();
        var user = userService.getByUsername(detailUser.getUsername());
        return user.getId();
    }
}
