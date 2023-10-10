package com.app.ptever.java.com.app.ptever;

import com.app.ptever.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommunityMapperTests {

    @Autowired
    private CommunityMapper communityMapper;

    @Test
    public void selectByPostIdTest(){
        Long postId = 64L;
        log.info("{}", communityMapper.selectByPostId(postId).get().getUserProfilePath());
    }
}
