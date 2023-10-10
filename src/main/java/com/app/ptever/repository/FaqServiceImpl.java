package com.app.ptever.repository;

import com.app.ptever.dao.FaqDAO;
import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.FaqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {

    private final FaqDAO faqDAO;
    @Override
    public void register(FaqVO faqVO) {
        faqDAO.register(faqVO);
    }

    @Override
    public int findTotalByUserId(Long userId) {
        return faqDAO.readTotalByUserId(userId);
    }

    @Override
    public List<FaqVO> findAllByUserId(Pagination pagination, Long userId) {
        return faqDAO.readAllByUserId(pagination,userId);
    }
}
