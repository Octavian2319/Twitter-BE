package app.entity;

import app.Post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private int id;
    @NonNull
    private String username;
    private String firstName;
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}
