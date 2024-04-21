package app.Service;

import app.DTO.PostDTO;
import app.Entity.Post;

import java.util.List;

public interface PostService {

     void createPost(String username, PostDTO postDTO);
     void deletePost(int id);
     List<Post> AllPost();
}
