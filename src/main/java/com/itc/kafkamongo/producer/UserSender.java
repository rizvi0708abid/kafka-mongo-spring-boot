package com.itc.kafkamongo.producer;

import com.itc.kafkamongo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserSender {
    private static final Logger LOG = LoggerFactory.getLogger(UserSender.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Value("${app.topic.example}")
    private String topic;

    public void send(User data){
        LOG.info("sending data='{}' to topic='{}'", data, topic);

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }
}
