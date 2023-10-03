package com.app.ptever.dao;

import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class EventDAO {
    private final EventMapper eventMapper;

    public void register(EventVO eventVO){
        eventMapper.registerEvent(eventVO);
    }
}
