package com.app.ptever;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.FaqVO;
import com.app.ptever.domain.vo.NoticeVO;
import com.app.ptever.mapper.FaqMapper;
import com.app.ptever.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
public class NoticeMapperTests {

    @Autowired
    private NoticeMapper noticeMapper;

    private Pagination pagination;


    @Autowired
    private FaqMapper faqMapper;


    @Test
    public void select(){
        int count = noticeMapper.selectAllCounts();
        System.out.println(count);
    }

    @Test
    public void selectAll(Pagination pagination){
        List<NoticeVO> no = noticeMapper.selectAllNotice(pagination);
        System.out.println("no = " + no);
    }

    @Test
    public void insertFAQ(FaqVO faqVO){
        faqVO.setFaqTitle("test");
        faqVO.setFaqContent("test");
        faqVO.setFaqId(9999);
        faqVO.setUserId(999L);

        faqMapper.registerFAQ(faqVO);
    }

    @Test
    public void register(){
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setNoticeTitle("8월 공휴일 (8/15) 고객센터 운영시간 안내");
        noticeVO.setCreateDate(LocalDate.from(LocalDateTime.parse("2022-08-12 09:32", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        noticeVO.setNoticeRegisterDate(LocalDate.from(LocalDateTime.parse("2022-08-12 09:32", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        noticeVO.setUpdateDate(LocalDate.from(LocalDateTime.parse("2022-08-12 09:32", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));

        noticeVO.setNoticeContent(
                "<p>안녕하세요. 크루님 :)</p>\n" +
                        "<p>프립 고객센터입니다.</p>\n" +
                        "<p><br></p>\n" +
                        "<p>8월 15일(월) 광복절, 고객센터 운영시간이 단축되어 안내드립니다.</p>\n" +
                        "<p><br></p>\n" +
                        "<p><strong><span style=\"font-size: 16px; background-color: rgb(239, 239, 239);\">[프립 고객센터 운영 시간 안내]</span></strong></p>\n" +
                        "<p>- 8월 15일(월) : 광복절</p>\n" +
                        "<p><span style=\"color: rgb(226, 80, 65);\">- &nbsp;카카오톡 채널 운영 시간 : 오전 10:00 ~ 오후 1:00</span></p>\n" +
                        "<p><br></p>\n" +
                        "<p>주말, 공휴일은 카카오톡 채널만 운영되며</p>\n" +
                        "<p>취소, 일정 변경 등 일부 문의에 대한 처리가 제한될 수 있으니 참고 부탁드립니다\uD83D\uDE4F</p>\n" +
                        "<p><br></p>\n" +
                        "<p>감사합니다.</p>\n" +
                        "<p>프립 고객센터 드림</p>");

        noticeMapper.registerNotice(noticeVO);
    }

}
