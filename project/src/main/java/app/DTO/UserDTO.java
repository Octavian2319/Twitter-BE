package app.DTO;

import app.Entity.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String username;

    private String firstName;

    private String lastName;
    private String email;
    private String password;

    private List<Post> posts;
    private Integer following;
    private Integer followers;
}
