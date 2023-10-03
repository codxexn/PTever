package com.app.ptever;

import com.app.ptever.domain.vo.CourseVO;
import com.app.ptever.mapper.CourseMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CourseMapperTests {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void selectByIdTest() {
//        CourseVO courseVO = new CourseVO();
        courseMapper.selectById(1L).map(CourseVO::toString).ifPresent(log::info);

    }
}
