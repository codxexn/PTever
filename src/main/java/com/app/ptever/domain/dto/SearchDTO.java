package com.app.ptever.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SearchDTO {
    private List<CourseSelectDTO> courseLists;
//    private List<ShoppingMallDTO> productLists;

    // 강의 총 개수
    private int courseTotalCount;


}
