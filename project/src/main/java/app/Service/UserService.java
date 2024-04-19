package app.Service;

import app.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void register(User user);
    User searchUser(String username);
}
