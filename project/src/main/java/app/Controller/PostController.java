package app.Controller;

import app.DTO.PostDTO;
import app.Entity.Post;
import app.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/{username}/create-post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createPost(@PathVariable("username") String username, @RequestBody PostDTO postDTO){
         postService.createPost(username, postDTO);
    }
    @DeleteMapping("/delete-post/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable int id ){
        postService.deletePost(id);
    }

    @GetMapping("/all-posts")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Post> allPost(){
        return postService.AllPost();
    }

}
