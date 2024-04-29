package app.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likes_table")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="post_id")
    private Post post;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id")
    private User user;
}
