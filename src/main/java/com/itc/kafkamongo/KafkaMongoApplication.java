package com.itc.kafkamongo;

import com.itc.kafkamongo.model.User;
import com.itc.kafkamongo.producer.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaMongoApplication{
	public static void main(String[] args) {
		SpringApplication.run(KafkaMongoApplication.class, args);
	}
}
