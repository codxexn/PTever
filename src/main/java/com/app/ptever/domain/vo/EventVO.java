package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class EventVO implements Serializable {
    // 이벤트 id
    private Integer eventId;
    // 이벤트 제목
    private String eventTitle;
    // 이벤트 내용
    private String eventContent;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
}
