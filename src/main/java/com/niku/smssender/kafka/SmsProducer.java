package com.niku.smssender.kafka;

import com.niku.smssender.dto.SmsEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsProducer {

    private final KafkaTemplate<String, SmsEvent> kafkaTemplate;

    private static final String TOPIC_NAME = "sms-topic";

    public void sendSmsEvent(SmsEvent smsEvent) {

        kafkaTemplate.send(
                TOPIC_NAME,
                smsEvent
        );

        System.out.println("Event sent to Kafka: " + smsEvent);
    }
}