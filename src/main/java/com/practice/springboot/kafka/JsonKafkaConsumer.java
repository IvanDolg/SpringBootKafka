package com.practice.springboot.kafka;

import com.practice.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer   {
    private final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class); 

    @KafkaListener(topics = "${spring.kafka.topic -json.name}", groupId = "${spring.kafka.consumer.group-id}  ")
    public void consume(User user){
        logger.info(String.format("Json message recieved -> %s", user.toString()));
    }
}
