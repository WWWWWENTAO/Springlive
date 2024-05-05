package net.nvsoftware.springmono.controller;

import net.nvsoftware.springmono.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home () {
        return "NVsoftware Home";
    }


    @RequestMapping(value="/user", method= RequestMethod.POST)
    public User user() {
        User user = new User();
        user.setId("3100");
        user.setEmail("info@techbow.com");
        user.setName("nvsoftware");

        return user;
    }


    @GetMapping("/user/{id}/{username}")
    public User userByPathVariable(@PathVariable String id, @PathVariable("username") String name ) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail("info@techbow.com");
        return user;
    }

}
