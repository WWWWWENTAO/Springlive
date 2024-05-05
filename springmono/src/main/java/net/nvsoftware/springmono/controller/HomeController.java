package net.nvsoftware.springmono.controller;

import net.nvsoftware.springmono.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
