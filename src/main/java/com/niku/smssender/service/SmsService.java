package com.niku.smssender.service;

import com.niku.smssender.dto.SmsEvent;
import com.niku.smssender.dto.SmsRequest;
import com.niku.smssender.dto.SmsResponse;
import com.niku.smssender.kafka.SmsProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final SmsProducer smsProducer;

    public SmsResponse sendMessage(SmsRequest smsRequest){

        // redis check for blocked id
        String blockedKey = "blocked:" + smsRequest.getId();

        Boolean isBlocked = redisTemplate.hasKey(blockedKey);

        if (Boolean.TRUE.equals(isBlocked)) {

            return SmsResponse.builder()
                    .status("FAILED")
                    .message("User is blocked")
                    .build();
        }

        // send message via external API
        // need to mock it
        // mocked randomly
        boolean vendorSuccess = Math.random() > 0.2;
        if (!vendorSuccess) {

            return SmsResponse.builder()
                    .status("FAILED")
                    .message("SMS vendor failed")
                    .build();
        }

        // need to add blocking login
        // random blocking for now

        boolean blockIt = Math.random() < 0.05; // 5 out of 100
        if (blockIt) {
            redisTemplate.opsForValue().set(blockedKey, 1);
            return SmsResponse.builder()
                    .status("FAILED")
                    .message("You are blocked (randomly)")
                    .build();

        }

        System.out.println("Event about to be sent");

        SmsEvent event = SmsEvent.builder()
                .userId(smsRequest.getId())
                .recipient(smsRequest.getRecipientContact())
                .message(smsRequest.getMessage())
                .status("SUCCESS")
                .build();

        smsProducer.sendSmsEvent(event);

        //System.out.println("if failed errorin event sending");


        return SmsResponse.builder()
                .status("SUCCESS")
                .message("SMS sent successfully")
                .build();
    }

}
