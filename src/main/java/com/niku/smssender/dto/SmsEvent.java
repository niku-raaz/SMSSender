package com.niku.smssender.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmsEvent {

    private Long userId;
    private String recipient;
    private String message;
    private String status;
}
