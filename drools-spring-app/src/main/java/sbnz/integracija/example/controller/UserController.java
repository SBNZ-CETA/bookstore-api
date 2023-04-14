package sbnz.integracija.example.controller;

import dtos.RegisterDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sbnz.integracija.example.service.UserService;

@RestController
@RequestMapping(path="/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping(path="/register")
    public boolean register(@RequestBody RegisterDto request){
        return userService.register(request);
    }

}
