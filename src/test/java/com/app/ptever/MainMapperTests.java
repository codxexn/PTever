package com.app.ptever;

import com.app.ptever.domain.Search;
import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.ShoppingMallDTO;
import com.app.ptever.domain.dto.ShoppingMallSelectDTO;
import com.app.ptever.mapper.MainMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MainMapperTests {
    @Autowired
    private MainMapper mainMapper;


    @Test
    public void selectByCourseTest() {
        mainMapper.selectAllByCourse().stream().map(CourseSelectDTO :: toString).forEach(log::info);
    }

    @Test
    public void selectLatestDateByCourseTest() {
        mainMapper.selectAllLatestDateByCourse().stream().map(CourseSelectDTO :: toString).forEach(log::info);
    }

    @Test
    public void selectLatestDateByCommunityTest() {
        mainMapper.selectAllLatestDateByCommunity(2L).stream().map(PostDTO::toString).forEach(log::info);
    }

    @Test
    public void selectTest() {
        Search search = new Search();
        search.setKeyword("스트레칭");

        List<CourseSelectDTO> result = mainMapper.selectSearchByCourse(search);
        for(CourseSelectDTO course : result ) {
            log.info(course.toString());
        }
    }

    @Test
    public void selectProductTest() {
        Search search = new Search();
        search.setKeyword("프로틴");

        List<ShoppingMallSelectDTO> result = mainMapper.selectSearchByProduct(search);
        for(ShoppingMallSelectDTO product : result ) {
            log.info(product.toString());
        }
    }

    @Test
    public void testSelectSearchByCourse() {
        // 검색 조건을 설정합니다.
        Search search = new Search();
        search.setKeyword("아 ");  // 원하는 키워드로 설정
        // MainMapper 인터페이스의 selectSearchByCourse 메서드를 호출하여 테스트합니다.
        List<CourseSelectDTO> result = mainMapper.selectSearchByCourse(search);

        // 테스트 결과를 확인하는 코드를 작성합니다.
        for (CourseSelectDTO course : result) {
            System.out.println(course);
        }
    }


}