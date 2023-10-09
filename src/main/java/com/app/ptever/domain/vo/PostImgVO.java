package com.app.ptever.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Data
public class PostImgVO implements Serializable {
    //게시글 이미지 Id
    private Long postImgId;
    // 원본 파일 이름
    private String originFileName;
    // 서버에 저장된 파일 이름
    private String storedFileName;
    // 썸네일
    private String storedThumbnail;
    // 파일 크기
    private Long fileSize;
    // 파일 생성 날짜
    private LocalDate createFileDate;
    // 파일 삭제 여부(default: false(삭제 x), true(삭제 됨))
    private String fileDeleteCheck;
    // 이미지 경로
    private String imagePath;
    // 생성 날짜
    private LocalDateTime createDate;
    // 업데이트 날짜
    private LocalDateTime updateDate;
    //===============================
    // 게시물 id
    private Long postId;
}
