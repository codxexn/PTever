package com.app.ptever.repository;

import com.app.ptever.dao.NoticeDAO;
import com.app.ptever.domain.vo.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDAO noticeDAO;

    @Override
    public void register(NoticeVO noticeVO) {
        noticeDAO.register(noticeVO);
    }

    @Override
    public List<NoticeVO> selectNotice() {
        return noticeDAO.select();
    }
}
