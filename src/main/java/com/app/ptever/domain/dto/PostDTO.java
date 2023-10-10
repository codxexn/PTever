package com.app.ptever.domain.dto;


import com.app.ptever.domain.vo.PostImgVO;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Data
public class PostDTO {
    private Long postId;
    private Long communityId;
    private Long userId;
    private String userName;
    private String postTitle;
    private String postContent;
    private LocalDateTime postDate;
    private LocalDateTime postUpdateDate;
    private String communityType;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String userProfilePath;
    private String userNickname;
    private String imagePath;
}
