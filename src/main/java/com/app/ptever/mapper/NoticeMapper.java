package com.app.ptever.mapper;

import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.domain.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    //    이벤트 등록
    public void registerNotice(NoticeVO noticeVO);

    //    이벤트 조회
    public List<NoticeVO> selectNotice();
}
