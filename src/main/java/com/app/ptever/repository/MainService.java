package com.app.ptever.repository;

import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.PostDTO;

import java.util.List;

public interface MainService {
    // 강의 별점순으로 가져오기
    public List<CourseSelectDTO> getScoreCourseList();

    // 강의 최신순으로 가져오기
    public List<CourseSelectDTO> getLatestDateCourseList();

    // 최신순으로 개별 게시판 게시물 조회(메인에는 소도구 거래만)
    public List<PostDTO> getLatestDateCommunityList();
}
