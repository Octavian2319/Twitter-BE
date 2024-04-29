package app.Service;

import app.DTO.PostDTO;
import app.DTO.ReplyDTO;
import app.Entity.Post;
import app.Entity.Reply;
import app.Entity.User;
import app.Repository.PostRepo;
import app.Repository.ReplyRepo;
import app.Repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ReplyServiceImp implements ReplyService{
    private final ReplyRepo replyRepo;
    private final UserRepo userRepo;
    private final PostRepo postRepo;
    @Override
    public void addReply(String username, Integer postId, ReplyDTO replyDTO) {
        User foundUser=userRepo.findByUsername(username);
        Post post=postRepo.findById(postId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(foundUser==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Reply reply=new Reply();
        reply.setUser(foundUser);
        reply.setPost(post);
        reply.setMessage(replyDTO.getReply());
        replyRepo.save(reply);
    }

    @Override
    public void removeReply(String username, Integer postId) {
        User user =userRepo.findByUsername(username);
        Post post=postRepo.findById(postId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        if(user==null){
            log.info("user null");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        log.info("Remove reply");
        List<Reply> replies = replyRepo.findAllByUserAndPost(user, post);
        replyRepo.delete(replies.get(0));
    }
}
