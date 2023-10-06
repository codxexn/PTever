package com.app.ptever;

import com.app.ptever.domain.vo.NoticeVO;
import com.app.ptever.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@Slf4j
public class NoticeMapperTests {

    @Autowired
    private NoticeMapper noticeMapper;


    @Test
    public void register(){
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle("현충일(6/6) 고객센터 운영시간 안내");
        noticeVO.setNoticeContent("<p>안녕하세요. 크루님 :)</p>\n" +
                "<p>프립입니다.</p>\n" +
                "<p><br></p>\n" +
                "<p>6월 6일 현충일의 <span style=\"color: rgb(226, 80, 65);\">고객센터 운영 시간이 일부 단축</span>되어 안내해드립니다.</p>\n" +
                "<p><br></p>\n" +
                "<p><strong><span style=\"background-color: rgb(247, 218, 100);\">[프립 고객센터 운영 시간 안내]</span></strong></p>\n" +
                "<p>- 일자 : 6월 6일 (화) 현충일</p>\n" +
                "<p>- 카카오톡 채널 운영 시간 : <strong><span style=\"color: rgb(226, 80, 65);\">오전 10:00 ~ 오후 1:00</span></strong></p>\n" +
                "<p><br></p>\n" +
                "<p>주말, 공휴일에는 취소 및 결제 관련 일부 문의에 대한 처리가 제한될 수 있는 점 양해 부탁드리며,</p>\n" +
                "<p>문의 사항은 카카오톡 채널 @프립 로 남겨주시면 순차적으로 처리해드릴 예정입니다.</p>\n" +
                "<p><br></p>\n" +
                "<p>감사합니다.</p>\n" +
                "<p>프립 고객센터 드림</p>");
        noticeVO.setCreateDate(LocalDate.from(LocalDateTime.parse("2023-06-01 08:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        noticeVO.setNoticeRegisterDate(LocalDate.from(LocalDateTime.parse("2023-06-01 08:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        noticeVO.setUpdateDate(LocalDate.from(LocalDateTime.parse("2023-06-01 08:31", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));

        noticeMapper.registerNotice(noticeVO);
    }

}
