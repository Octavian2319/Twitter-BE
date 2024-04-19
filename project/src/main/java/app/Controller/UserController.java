package app.Controller;

import app.entity.User;
import app.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registerUsers(@RequestBody User user){
        userService.register(user);
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User search(@PathVariable String username)  {
        User user = userService.searchUser(username);
        if(user !=null){
            log.info("S-a gasit user-ul");
            return user;
        }
        else{
            log.info("User-ul nu exista");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}

