package app.Repository;

import app.Entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepo extends JpaRepository<Follow,Integer> {
}
