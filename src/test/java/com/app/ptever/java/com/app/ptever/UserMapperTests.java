package com.app.ptever.java.com.app.ptever;


import com.app.ptever.domain.vo.UserVO;
import com.app.ptever.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void loginTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("test1@naver.com");
        userVO.setUserPassword("1234");

        userMapper.selectByLogin(userVO).map(UserVO::toString).ifPresent(log::info);
    }
}
