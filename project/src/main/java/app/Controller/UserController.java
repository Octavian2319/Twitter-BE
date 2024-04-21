package app.Controller;

import app.Entity.User;
import app.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registerUsers(@RequestBody User user){
        userService.register(user);
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User search(@PathVariable String username)  {
        return userService.searchUser(username);
    }

    @GetMapping("/all-users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> allUsers(){
        return userService.searchAll();
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable String username){
        userService.deleteUser(username);
    }



}

