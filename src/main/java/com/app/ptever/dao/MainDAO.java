package com.app.ptever.dao;

import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MainDAO {
    private final MainMapper mainMapper;

    // 강의 인기순 목록
    public List<CourseSelectDTO> findAllCourse() {
        return mainMapper.selectAllByCourse();
    }

    // 강의 최신순 목록
    public List<CourseSelectDTO> findAllLatestDateCourse() {
        return mainMapper.selectAllLatestDateByCourse();
    }
}
