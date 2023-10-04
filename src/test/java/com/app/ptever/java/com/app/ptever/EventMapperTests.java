package com.app.ptever.java.com.app.ptever;


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

    public String imageToBase64(String filePath, String fileName){
        String base64Img = "";

        File f = new File(filePath + fileName);
        if (f.exists() && f.isFile() && f.length() > 0) {
            byte[] bt = new byte[(int) f.length()];
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(f);
                fis.read(bt);
                base64Img = new String(Base64.encodeBase64(bt));
            } catch (Exception e) {
                e.getMessage();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                } catch (Exception e) {
                }
            }
        }

        return base64Img;
    }

//    VARCHAR2(255) 크기로 인해 일부만 삽입
    @Test
    public void insertTest(){
        EventVO eventVO = new EventVO();

        eventVO.setEventTitle("2019 만우절 이벤트 당첨자 발표");
        eventVO.setEventContent("안녕하세요, 피테버입니다. :)\n" +
                "4월 1일 진행된 만우절 이벤트 당첨자를 발표합니다! \n" +
                "                             \n" +

                "당첨을 축하드립니다♥ \n"
//                +
//                "※ 당첨자분들께는 개인 연락처를 통해 별도 문자를 발송해 드렸습니다. \n" +
//                "만우절 이벤트에 참여해주신 많은 대원님들께 감사 인사 드립니다. \n" +
//                "앞으로도 피테버는 더 다양하고 즐거운 경험들로 대원님들의 일상을 채워드리도록 노력하겠습니다. \n" +
//                "감사합니다. "
        );
        eventVO.setCreateDate(LocalDate.now());
        eventVO.setUpdateDate(LocalDate.now());
        eventMapper.registerEvent(eventVO);
    }

}
