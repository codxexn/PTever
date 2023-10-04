package com.app.ptever.repository;

import com.app.ptever.domain.dto.CourseSelectDTO;

import java.util.List;

public interface MainService {
    // 강의 별점순으로 가져오기
    public List<CourseSelectDTO> getScoreCourseList();

    // 강의 최신순으로 가져오기
    public List<CourseSelectDTO> getLatestDateCourseList();
}
