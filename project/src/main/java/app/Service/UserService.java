package app.Service;

import app.DTO.UserDTO;
import app.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void register(User user);
    UserDTO searchUser(String username);
    void deleteUser(String username);
    List<User> searchAll();
}
