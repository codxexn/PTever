package com.app.ptever.mapper;

import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.domain.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CourseMapper {

//    강의 아이디로 강의 상세정보 조회
    public Optional<CourseVO> selectById(Long courseId);
//    강의 아이디에 해당하는 모든 리뷰 조회
    public List<ReviewDTO> selectAllReview(Long courseId);
}
