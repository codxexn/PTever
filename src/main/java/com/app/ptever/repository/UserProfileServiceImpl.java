package com.app.ptever.repository;

import com.app.ptever.dao.UserProfileDAO;
import com.app.ptever.domain.vo.UserProfileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileDAO userProfileDAO;
    @Override
    public UserProfileVO findByUserId(Long userId) {
        return userProfileDAO.readByUserId(userId);
    }
}
