package app.Controller;

import app.Service.LikeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/")
public class LikeController {

    private LikeService likeService;

    @PostMapping("like/{integer}/{username}")
    void likePost(@PathVariable String username,@PathVariable Integer integer){
        likeService.likePost(username,integer);
    }

    @DeleteMapping("unlike/{integer}/{username}")
    void unlikePost(@PathVariable String username,@PathVariable Integer integer){
        likeService.unlikePost(username,integer);
    }
}
