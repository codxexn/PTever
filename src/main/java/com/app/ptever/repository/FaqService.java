package com.app.ptever.repository;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.FaqVO;

import java.util.List;

public interface FaqService {
//    FAQ 등록
    public void register(FaqVO faqVO);

//    user에 맞는 목록 개수
    public int findTotalByUserId(Long userId);

//    FAQ 불러오기
    public List<FaqVO> findAllByUserId(Pagination pagination, Long userId);

}
