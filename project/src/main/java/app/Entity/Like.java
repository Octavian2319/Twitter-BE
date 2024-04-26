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
    private int id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="like_id")
    private Post post;
}
