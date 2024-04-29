package app.Controller;

import app.DTO.ReplyDTO;
import app.Service.ReplyService;
import app.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class ReplyController {
    private ReplyService replyService;
    @PostMapping("add-reply/{username}/{postId}")
    void addReply(@PathVariable String username, @PathVariable Integer postId, @RequestBody ReplyDTO replyDTO){
        replyService.addReply(username,postId,replyDTO);
    }

    @DeleteMapping("remove-reply/{username}/{postId}")
    void removeReply(@PathVariable String username,@PathVariable Integer postId){
        replyService.removeReply(username,postId);
    }
}
