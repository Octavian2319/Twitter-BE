package app.Repository;

import app.Entity.Follow;
import app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepo extends JpaRepository<Follow,Integer> {

    Follow findByFollowerAndFollowed(User user1, User user2);
}
