package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class CouponVO implements Serializable {
    // 쿠폰 id
    private Integer couponId;
    // 쿠폰명
    private String couponTitle;
    // 생성 일자
    private LocalDate couponCreateDate;
    // 만료 일자
    private LocalDate couponEndDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // =============================
    private Integer userId; // 유저 id
}
