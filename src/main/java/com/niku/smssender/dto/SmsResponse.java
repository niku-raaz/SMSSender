package com.niku.smssender.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsResponse {

    @NotBlank(message = "Status should not be blank")
    private String status;

    private String message;
}
