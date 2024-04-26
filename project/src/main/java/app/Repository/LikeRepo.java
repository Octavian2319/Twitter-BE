package app.Repository;


import app.Entity.Like;
import app.Entity.Post;
import app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like,Integer> {
    boolean existsByUserAndPost(User user, Post post);
    void delete(Like like);
    Like findByPostAndUser(Post post, User user);
}
