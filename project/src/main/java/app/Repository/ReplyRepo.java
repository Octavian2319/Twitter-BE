package app.Repository;

import app.Entity.Post;
import app.Entity.Reply;
import app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepo extends JpaRepository<Reply,Integer> {

    Reply findByUserAndPost(User user, Post post);

    List<Reply> findAllByUserAndPost(User user, Post post);
}
