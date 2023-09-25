package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class PackageVO implements Serializable {
    // 패키지 주문 id
    private Integer packageId;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // =========================
    private Integer courseId; // 강의 id
    private Integer productId; // 상품 id
}
