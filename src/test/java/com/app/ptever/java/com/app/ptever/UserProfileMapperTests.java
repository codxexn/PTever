package com.app.ptever.java.com.app.ptever;


import com.app.ptever.mapper.UserProfileMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserProfileMapperTests {

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Test
    public void selectByUserIdTest(){
        log.info("{}", userProfileMapper.selectByUserId(1L));
    }
}
