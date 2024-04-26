package app.Service;

import app.DTO.UserDTO;
import app.Repository.UserRepo;
import app.Entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;

    @Override
    public void register(User user) {
        log.info("A fost adaugat un user\n");
        userRepo.save(user);
    }

    @Override
    public UserDTO searchUser(String username) {
        log.info("S-a cautat un user\n");
        User user= userRepo.findByUsername(username);
        if(username!=null){
            UserDTO userDto = new UserDTO();
            userDto.setUsername(user.getUsername());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setEmail(user.getEmail());
            return userDto;
        }
        else{
            log.info("User-ul nu exista");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteUser(String username) {
        User user=userRepo.findByUsername(username);
        if(username!=null){
            log.info("S-a sters un user!");
            userRepo.delete(user);
        }
        else{
            log.info("User-ul nu exista");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<User> searchAll() {
        return userRepo.findAll();
    }


}

