package com.app.ptever.dao;

import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.domain.vo.NoticeVO;
import com.app.ptever.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class NoticeDAO {

    private final NoticeMapper noticeMapper;
//    private final NoticeVO noticeVO;

    //    DB에 내용 등록
    public void register(NoticeVO noticeVO){
        noticeMapper.registerNotice(noticeVO);
    }

    //    조회
    public List<NoticeVO> select(){
        return noticeMapper.selectNotice();
    }
}
