package com.app.ptever.mapper;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.domain.vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EventMapper {

//    이벤트 등록
    public void registerEvent(EventVO eventVO);

//    이벤트 조회
    public List<EventVO> selectEvent();

    //    페이징 처리를 위한 개수 불러오기
    public int readAllCounts();

    //    페이징 처리를 위한 내용 불러오기
    public List<EventVO> readAllEvent(Pagination pagination);

}
