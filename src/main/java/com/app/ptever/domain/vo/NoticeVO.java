package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class NoticeVO implements Serializable {
    // 공지사항 id
    private Integer noticeId;
    // 제목
    private String noticeTitle;
    // 내용
    private String noticeContent;
    // 등록 날짜
    private LocalDate noticeRegisterDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
}
