package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
public class CommunityCommentVO implements Serializable {
    // 게시물 댓글
    private Long communityCommentId;
    // 내용
    private String commentContent;
    // 작성일
    private LocalDateTime commentDate;
    // 수정일
    private LocalDateTime commentUpdateDate;
    // 생성 날짜
    private LocalDate createDate;
    // 업데이트 날짜
    private LocalDate updateDate;
    // ==============================
    private Long userId; // 유저 id
    private Long communityId; // 커뮤니티 id
    private Long postId; // 게시물 id
}
