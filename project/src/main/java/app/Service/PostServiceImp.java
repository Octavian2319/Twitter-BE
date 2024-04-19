package app.Service;

import app.Repository.PostRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostServiceImp extends PostService{
    private final PostRepo postRepo;

    @Autowired
    public PostServiceImp(PostRepo postRepo) {this.postRepo = postRepo;}


}
