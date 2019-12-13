package mum.itweet.controller;

import mum.itweet.service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/following")

public class FollowingController {

    @Autowired
    private FollowingService followingService ;


}
