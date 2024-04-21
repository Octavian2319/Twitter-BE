package app.Service;

import app.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void register(User user);
    User searchUser(String username);
    void deleteUser(String username);
    List<User> searchAll();
}
