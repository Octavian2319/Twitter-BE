package app.Service;

import app.Entity.Like;
import app.Entity.Post;
import app.Entity.User;
import app.Repository.LikeRepo;
import app.Repository.PostRepo;
import app.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@Slf4j
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Postarea nu există"));
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Userul nu există");
        }

        if (likeRepo.existsByUserAndPost(user, post)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Userul a dat deja like la această postare");
        }
        log.info("Like la o postare");
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        likeRepo.save(like);
    }
    @Override
    public void unlikePost(String username,Integer postId){
        User user=userRepo.findByUsername(username);
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Postarea nu există"));
        if (user == null) {
            log.info("Userul nu există");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (!likeRepo.existsByUserAndPost(user, post)) {
            log.info("Userul nu a dat like la această postare");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST );
        }
        else{
            Like like=likeRepo.findByPostAndUser(post,user);
            likeRepo.delete(like);
        }
    }

}
