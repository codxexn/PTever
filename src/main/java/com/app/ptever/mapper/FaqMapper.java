package com.app.ptever.mapper;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.FaqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqMapper {

//    FAQ 등록
    public void registerFAQ(FaqVO faqVO);

//    FAQ 개수 불러오기
    public int selectTotalByUserId(Long userId);

//    FAQ 내용 불러오기
    public List<FaqVO> selectAllByUserId(Pagination pagination, Long userId);
}
