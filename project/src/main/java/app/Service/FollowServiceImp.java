package app.Service;

import app.Entity.Follow;
import app.Entity.User;
import app.Repository.FollowRepo;
import app.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class FollowServiceImp implements FollowService {
    private FollowRepo followRepo;
    private UserRepo userRepo;
    @Autowired
    public FollowServiceImp(FollowRepo followRepo, UserRepo userRepo) {
        this.followRepo = followRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void followUser(String username1, String username2) {
        User user1=userRepo.findByUsername(username1);
        User user2=userRepo.findByUsername(username2);
        Follow follow=new Follow();
        follow.setTimestamp(new Date());
        follow.setFollower(user1);
        follow.setFollowed(user2);
        log.info("Follow intre useri");
        followRepo.save(follow);
    }
}
