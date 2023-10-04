package com.app.ptever.mapper;

import com.app.ptever.domain.dto.CourseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface CourseMapper {

//    강의 아이디로 강의 상세정보 조회
    public Optional<CourseDTO> selectById(Long courseId);
}