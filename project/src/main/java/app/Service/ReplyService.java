package app.Service;

import app.DTO.ReplyDTO;

public interface ReplyService {
    void addReply(String username,Integer postId, ReplyDTO replyDTO);
    void removeReply(String username,Integer postId);
}
