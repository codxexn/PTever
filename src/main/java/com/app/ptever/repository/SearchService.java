package com.app.ptever.repository;

import com.app.ptever.dao.SearchDAO;
import com.app.ptever.domain.Search;
import com.app.ptever.domain.dto.SearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchDAO searchCourse;
    private final SearchDAO searchProduct;

    public SearchDTO getResult(Search search) {
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setCourseLists(searchCourse.findSearchByCourse(search));
        searchDTO.setCourseTotalCount(searchCourse.findCourseTotal(search));
//        searchDTO.setProductLists(searchProduct.findSearchByProduct(search));
        return searchDTO;
    }
}
