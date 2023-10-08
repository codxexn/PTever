package com.app.ptever.dao;

import com.app.ptever.domain.Search;
import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.ShoppingMallDTO;
import com.app.ptever.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class SearchDAO {
    private final MainMapper mainMapper;

    // 통합 검색 강의
    public List<CourseSelectDTO> findBySearchCourse(Search search) {
        return mainMapper.selectSearchByCourse(search);
    }

    // 강의 총 개수
    public int findCourseTotal(Search search) {
        return mainMapper.selectCourseTotal(search);
    }

    // 통합 검색 상품
//    public List<ShoppingMallDTO> findSearchByProduct(Search search) {
//        return mainMapper.selectSearchByProduct(search);
//    }
}

