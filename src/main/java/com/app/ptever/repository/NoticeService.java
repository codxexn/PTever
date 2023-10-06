package com.app.ptever.repository;

import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.domain.vo.NoticeVO;

import java.util.List;

public interface NoticeService {
    public void register(NoticeVO noticeVO);

    public List<NoticeVO> selectNotice();
}
