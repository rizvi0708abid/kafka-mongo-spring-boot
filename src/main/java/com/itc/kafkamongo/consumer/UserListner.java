package com.itc.kafkamongo.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itc.kafkamongo.model.User;
import com.itc.kafkamongo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;


@Service
public class UserListner {

    private static final Logger LOG = LoggerFactory.getLogger(UserListner.class);

    @Autowired
    UserRepository userRepository;

    @KafkaListener(topics = "${app.topic.example}")
    public void receive(@Payload User data,
                        @Headers MessageHeaders headers){
        LOG.info("received data='{}'", data);

         ObjectMapper objectMapper = new ObjectMapper();

         User user = objectMapper.convertValue(data,User.class);

         userRepository.save(user);

        headers.keySet().forEach(key -> {
            LOG.info("{}: {}", key, headers.get(key));
        });
    }

}
