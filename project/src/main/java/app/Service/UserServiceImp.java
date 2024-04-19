package app.Service;

import app.Repository.UserRepo;
import app.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public void register(User user) {
        log.info("A fost adaugat un user\n");
        userRepo.save(user);
    }

    @Override
    public User searchUser(String username) {
        log.info("S-a cautat un user\n");
        return userRepo.findByUsername(username);
    }




}

