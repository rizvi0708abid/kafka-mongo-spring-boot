package com.itc.kafkamongo.resource;

import com.itc.kafkamongo.model.User;
import com.itc.kafkamongo.producer.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "kafka")
public class UserResource {

    @Autowired
    private UserSender sender;

    @PostMapping(value = "/publish")
    public String sendMessage(@RequestBody User user){
        sender.send(user);
        return "Success in sending user";
    }

}
