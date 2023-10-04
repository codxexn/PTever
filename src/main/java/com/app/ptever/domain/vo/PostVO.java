package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
public class PostVO implements Serializable {
    // 게시물 id
    private Long postId;
    // 제목
    private String postTitle;
    // 내용
    private String postContent;
    // 작성일
    private LocalDate postDate;
    // 수정일
    private LocalDate postUpdateDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate UpdateDate;
    // ==========================
    private Long communityId; // 커뮤니티 id
    private Long UserId; // 유저 id
}
