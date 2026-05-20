package com.niku.smssender.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsRequest {

    @NotNull(message = "user id is required")
    private Long id;

    @NotBlank(message="Receivers Contact is mandatory")
    private String recipientContact;

    @NotBlank(message = "Message should not be blank")
    private String message;
}
