package com.app.ptever.repository;

import com.app.ptever.dao.EventDAO;
import com.app.ptever.domain.vo.EventVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventDAO eventDAO;
    @Override
    public void register(EventVO eventVO) {
        eventDAO.register(eventVO);
    }

    @Override
    public List<EventVO> selectEvent( ) {
        return eventDAO.select();
    }


}
