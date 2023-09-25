package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class WishlistVO implements Serializable {
    // 찜목록 id
    private Integer wishlistId;
    // 찜목록명
    private String wishlistTitle;
    // 찜 생성 날짜
    private LocalDate wishlistDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
}
