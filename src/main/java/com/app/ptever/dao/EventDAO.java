package com.app.ptever.dao;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class EventDAO {
    private final EventMapper eventMapper;
    private final EventVO eventVO;

//    DB에 내용 등록
    public void register(EventVO eventVO){
        eventMapper.registerEvent(eventVO);
    }

//    조회
    public List<EventVO> select(){
        return eventMapper.selectEvent();
    }

//    페이징 개수
    public int readAllCounts(){
        return eventMapper.readAllCounts();
    }

//    페이징 내용 불러오기
    public List<EventVO> readAllNotices(Pagination pagination){
        return eventMapper.readAllEvent(pagination);
    }
}
