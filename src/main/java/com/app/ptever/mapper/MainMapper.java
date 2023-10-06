package com.app.ptever.mapper;

import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.ShoppingMallDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    // 강의 인기순 목록 조회
    public List<CourseSelectDTO> selectAllByCourse();

    // 강의 최신순 목록 조회
    public List<CourseSelectDTO> selectAllLatestDateByCourse();


    // 최신순으로 개별 게시판 게시물 조회(메인에는 소도구 거래만)
    public List<PostDTO> selectAllLatestDateByCommunity(Long communityId);

    // 통합 검색 중 강의 검색
//    public List<CourseSelectDTO> selectSearchByCourse(Search search);

    // 통합 검색 중 상품 검색
//    public List<ShoppingMallDTO> selectSearchByProduct(Search search);
}
