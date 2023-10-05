package com.app.ptever.mapper;

import com.app.ptever.domain.vo.EventVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EventMapper {

//    이벤트 등록
    public void registerEvent(EventVO eventVO);

//    이벤트 조회
    public List<EventVO> selectEvent();

//    이벤트 삭제


}
