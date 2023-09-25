package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class UserAddressVO implements Serializable {
    // 우편번호
    private Integer userZipCode;
    // 주소
    private String userAddress;
    // 상세 주소
    private String userAddressDetail;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ===============================
    private Integer userId; // 유저 id
}
