package com.niku.smssender.service;

import com.niku.smssender.dto.SmsRequest;
import com.niku.smssender.dto.SmsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final RedisTemplate<String, Object> redisTemplate;

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




        return SmsResponse.builder()
                .status("SUCCESS")
                .message("SMS sent successfully")
                .build();
    }

}
