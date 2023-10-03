package com.app.ptever.repository;

import com.app.ptever.dao.CommunityDAO;
import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.vo.PostVO;
import com.app.ptever.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CommunityServiceImpl implements CommunityService {
    private final CommunityDAO communityDAO;
    @Override
    public List<PostDTO> findAll() {
        return communityDAO.readAll();
    }
}
