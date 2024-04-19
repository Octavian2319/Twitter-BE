package app.Post;

import app.Reply.Reply;
import app.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
    private Long timestamps;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    //private Reply reply;
}
