package com.app.ptever.mapper;

import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.ReviewDTO;
import com.app.ptever.domain.pagination.Pagination;
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
//    해당 강의 제외 6개 강의 랜덤으로 조회
    public List<CourseVO> selectOtherCourse(Long courseId);
//    해당 강의에 대한 평점을 강의 후기 테이블에서 가지고 온 뒤 평균 내기
    public Double selectAvgByCourseId(Long courseId);

//    전체 강의 목록 페이징
    public List<CourseSelectDTO> selectAllCourse(Pagination pagination);

//    게시물 전체 개수 조회
    public int selectTotalAllCourse();
}
