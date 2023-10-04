package com.app.ptever.java.com.app.ptever;

import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.mapper.MainMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MainMapperTests {
    @Autowired
    private MainMapper mainMapper;
    @Test
    public void selectByCourseTest() {
        mainMapper.selectAllByCourse().stream().map(CourseSelectDTO :: toString).forEach(log::info);
    }
}
