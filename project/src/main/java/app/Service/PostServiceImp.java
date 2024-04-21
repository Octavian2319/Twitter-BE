package app.Service;

import app.DTO.PostDTO;
import app.Entity.Post;
import app.Entity.User;
import app.Repository.PostRepo;
import app.Repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PostServiceImp implements PostService{
    private final PostRepo postRepo;
    private final UserRepo userRepo;

   public void createPost(String username , PostDTO postDTO){
        User foundUser = userRepo.findByUsername(username);
        log.info("S-a creat o postare");
        Post post = new Post();
        post.setMessage(postDTO.getMessage());
        post.setUser(foundUser);
        post.setTimestamps(new Date());
        postRepo.save(post);
    }

    @Override
    public void deletePost(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public List<Post> AllPost() {
        return postRepo.findAll();
    }
}
