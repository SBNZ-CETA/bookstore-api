package sbnz.integracija.example.controller;

import lombok.AllArgsConstructor;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import dtos.RegisterDto;
import sbnz.integracija.example.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping(path="/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private UserService userService;

    @PostMapping(path="/register")
    public boolean register(@RequestBody RegisterDto request){
        return userService.register(request);
    }

    //PRIMERI ZA AUTHORIZATION!
    @GetMapping("/usr")
    @RolesAllowed({"REGULAR"})
    public String userEndpoint(){
        return "YOUR USER";
    }

    @GetMapping("/adm")
    // @PreAuthorize("hasAuthority('ADMIN')")
    @RolesAllowed({"ADMIN"})
    public String adminEndpoint(){
        return "YOUR ADMIN";
    }

    @GetMapping("/usrAdm")
    // @PreAuthorize("hasAnyAuthority('ADMIN','REGULAR')")
    @RolesAllowed({"ADMIN","REGULAR"})
    public String userAdminEndpoint(){
        return "YOUR USER or ADMIN";
    }

    //AKO OCEMO DA ENDPOINT BUDE SVIMA DOSTUPAN ONDA STAVITI U WEB-SECURITY-CONFIG, ANT MATCHERS PUTANJU
    @GetMapping("/noUsr")
    public String noUserEndpoint(){
        return "YOUR NO USER!";
    }
}
