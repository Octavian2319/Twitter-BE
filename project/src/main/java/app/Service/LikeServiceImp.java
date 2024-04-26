package app.Service;

import app.Entity.Like;
import app.Entity.Post;
import app.Entity.User;
import app.Repository.LikeRepo;
import app.Repository.PostRepo;
import app.Repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LikeServiceImp implements LikeService{
    private LikeRepo likeRepo;
    private UserRepo userRepo;
    private PostRepo postRepo;

    public LikeServiceImp(LikeRepo likeRepo, UserRepo userRepo, PostRepo postRepo) {
        this.likeRepo = likeRepo;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @Override
    public void likePost(String username, Integer postId) {
        User user = userRepo.findByUsername(username);
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Postul nu există"));
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Userul nu există");
        }

        if (likeRepo.existsByUserAndPost(user, post)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Userul a dat deja like la această postare");
        }
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        likeRepo.save(like);
    }

}
