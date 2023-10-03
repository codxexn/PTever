package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class WishlistCourseVO implements Serializable {
    // 강의 찜 목록
    private Long courseWishlistId;
    // 찜 생성 날짜
    private LocalDate wishlistDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ===========================
    private Long courseId; // 강의 id
}
