package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class WishlistTrainerVO implements Serializable {
    // 트레이너 찜 목록 id
    private Long trainerWishlistId;
    // 찜 생성 날짜
    private LocalDate wishlistDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ===========================
    private Long userId; // 유저 id
}
