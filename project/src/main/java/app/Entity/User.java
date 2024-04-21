package app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String username;

    private String firstName;

    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "follower",cascade = CascadeType.ALL)
    private  List<Follow> following;

    @JsonIgnore
    @OneToMany(mappedBy = "followed",cascade = CascadeType.ALL)
    private List<Follow> followers;

}
