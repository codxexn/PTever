package com.app.ptever.repository;

import com.app.ptever.dao.SearchDAO;
import com.app.ptever.domain.Search;
import com.app.ptever.domain.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class SearchServiceImpl implements SearchService {
    private final SearchDAO searchCourse;
    private final SearchDAO searchProduct;

    @Override
    public SearchDTO getResult(Search search) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setCourseLists(searchCourse.findBySearchCourse(search));
        searchDTO.setCourseTotalCount(searchCourse.findCourseTotal(search));
//        searchDTO.setProductLists(searchProduct.findSearchByProduct(search));
        return searchDTO;
    }
}
