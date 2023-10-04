package com.app.ptever.mapper;

import com.app.ptever.domain.dto.CourseSelectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    public List<CourseSelectDTO> selectAllByCourse();
}
