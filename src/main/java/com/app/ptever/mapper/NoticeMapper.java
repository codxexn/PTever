package com.app.ptever.mapper;

import com.app.ptever.domain.pagination.Pagination;
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

//    페이징 처리를 위한 개수 불러오기
    public int selectAllCounts();

//    페이징 처리를 위한 내용 불러오기
    public List<NoticeVO> selectAllNotice(Pagination pagination);

}
