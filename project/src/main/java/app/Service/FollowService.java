package app.Service;

public interface FollowService {
    void followUser(String username1,String username2);
    void unfollow(String username1,String username2);
}
