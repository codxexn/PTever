package com.app.ptever.dao;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.FaqVO;
import com.app.ptever.mapper.FaqMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class FaqDAO {
    private final FaqMapper faqMapper;

//    문의 내용 저장
    public void register(FaqVO faqVO){
        faqMapper.registerFAQ(faqVO);
    }

//    문의 내용 개수 불러오기
    public int readTotalByUserId(Long userId){
        return faqMapper.selectTotalByUserId(userId);
    }

    //    문의 내용 불러오기
    public List<FaqVO> readAllByUserId(Pagination pagination, Long userId){
        return faqMapper.selectAllByUserId(pagination,userId);
    }
}
