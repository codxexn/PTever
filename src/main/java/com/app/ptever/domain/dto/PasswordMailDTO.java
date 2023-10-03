package com.app.ptever.domain.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
public class PasswordMailDTO {
    private String mailAddress;
    private String mailTitle;
    private String mailContent;
}
