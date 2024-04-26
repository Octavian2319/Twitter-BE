package app.Service;


public interface LikeService {
    void likePost(String username, Integer postId);
    void unlikePost(String username,Integer postId);
}
