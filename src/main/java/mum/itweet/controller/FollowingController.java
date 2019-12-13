package mum.itweet.controller;

import mum.itweet.model.Following;
import mum.itweet.model.User;
import mum.itweet.model.dto.FollowingDto;
import mum.itweet.service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/following")

public class FollowingController {

    @Autowired
    private FollowingService followingService ;


   /* @PostMapping()
    public Following add(@RequestBody FollowingDto followingDto){
        return followingService.create(followingDto);
    }
*/
   /* @GetMapping("/{id}")
    public Following getOne(@PathVariable long followingId){
        return followingService.get(followingId);
    }*/

   /* @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        try {
            followingService.delete(id);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }   */





}
