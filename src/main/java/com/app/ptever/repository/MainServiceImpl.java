package com.app.ptever.repository;

import com.app.ptever.dao.MainDAO;
import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MainServiceImpl implements MainService {
    private final MainDAO mainDAO;


    // 강의 목록
    @Override
    public List<CourseSelectDTO> getScoreCourseList() {
        return mainDAO.findAllCourse();
    }
}
