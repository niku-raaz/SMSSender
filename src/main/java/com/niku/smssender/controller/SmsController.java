package com.niku.smssender.controller;

import com.niku.smssender.dto.SmsRequest;
import com.niku.smssender.dto.SmsResponse;
import com.niku.smssender.service.SmsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/sms")
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/send")
    public SmsResponse sendSMS(@Valid @RequestBody SmsRequest smsRequest){
        return smsService.sendMessage(smsRequest);
    }
}
