package app.Controller;

import app.Service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
public class FollowController {
    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/{username1}/{username2}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void userFollow(@PathVariable String username1,@PathVariable String username2){
        followService.followUser(username1,username2);
    }

}
