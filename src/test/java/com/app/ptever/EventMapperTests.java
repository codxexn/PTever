package com.app.ptever;


import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.mapper.EventMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

@SpringBootTest
@Slf4j
public class EventMapperTests {

    @Autowired
    private EventMapper eventMapper;



//    VARCHAR2(255) 크기로 인해 일부만 삽입
    @Test
    public void insertTest(){
        EventVO eventVO = new EventVO();

        eventVO.setEventTitle("피테버패스 구매 이벤트 에어팟 및 아이폰XS 당첨자 발표");
        eventVO.setEventContent("<p>안녕하세요, 피테버입니다. :)</p>\n" +
                "<p>11/26부터 11/30까지 진행된 피테버패스 구매 이벤트 에어팟 및 아이폰XS 당첨자를 발표합니다!</p>\n" +
                "<p>\n" +
                "    <img src=\"https://res.cloudinary.com/frientrip/image/upload/v1543983203/1543983204537_vpnwet.png\" class=\"fr-fic fr-dib\">\n" +
                "</p>\n" +
                "<p>다시 한 번 당첨을 축하드리며, 피테버패스를 구매해 주셔서 고맙습니다.♥</p>\n" +
                "<p>※ 당첨자분들께는 개인 연락처를 통해 별도 문자를 발송해 드렸습니다.</p>\n" +
                "<p><br></p><p>피테버패스 이벤트에 참여해주신 많은 대원님들께 감사 인사 드립니다.</p>\n" +
                "<p>앞으로도 피테버는 더 다양하고 즐거운 경험들로 대원님들의 일상을 채워드리도록 노력하겠습니다.</p>\n" +
                "<p>\n" +
                "    <br>\n" +
                "</p>\n" +
                "<p>감사합니다.</p>"
        );
        eventVO.setCreateDate(LocalDate.now());
        eventVO.setUpdateDate(LocalDate.now());
        eventMapper.registerEvent(eventVO);
    }

}
