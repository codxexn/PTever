package com.app.ptever.repository;

import com.app.ptever.domain.vo.EventVO;

import java.util.List;
import java.util.Optional;

public interface EventService {
    public void register(EventVO eventVO);

    public List<EventVO> selectEvent();
}
