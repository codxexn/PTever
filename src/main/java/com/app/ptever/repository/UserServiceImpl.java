package com.app.ptever.repository;

import com.app.ptever.dao.UserDAO;
import com.app.ptever.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    @Override
    public Optional<UserVO> login(UserVO userVO) {
        return userDAO.login(userVO);
    }

    @Override
    public void save(UserVO userVO) {
        userDAO.write(userVO);
    }

    @Override
    public Optional<UserVO> checkByEmail(String userEmail) {
        return userDAO.findByEmail(userEmail);
    }

    @Override
    public void deactivateUser(UserVO userVO) {
        userDAO.modifyUserState(userVO);
    }


}
