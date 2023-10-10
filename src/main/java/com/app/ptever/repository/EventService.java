package com.app.ptever.repository;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.domain.vo.NoticeVO;

import java.util.List;
import java.util.Optional;

public interface EventService {
    public void register(EventVO eventVO);

    public List<EventVO> selectEvent();

    //    페이징 처리를 위해 개수 불러오기
    public int selectAllCounts();

    //    페이징을 위한 공지 불러오기
    public List<EventVO> selectAllEvents(Pagination pagination);
}
