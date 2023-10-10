package com.app.ptever.repository;

import com.app.ptever.dao.MainDAO;
import com.app.ptever.domain.dto.CourseSelectDTO;
import com.app.ptever.domain.dto.PostDTO;
import com.app.ptever.domain.dto.ShoppingMallSelectDTO;
import com.app.ptever.domain.vo.PostImgVO;
import com.app.ptever.mapper.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PublicKey;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MainServiceImpl implements MainService {
    private final MainDAO mainDAO;


    // 강의 인기순 목록
    @Override
    public List<CourseSelectDTO> getScoreCourseList() {
        return mainDAO.findAllCourse();
    }

    // 강의 최신순 목록
    @Override
    public List<CourseSelectDTO> getLatestDateCourseList() {
        return mainDAO.findAllLatestDateCourse();
    }

    public List<ShoppingMallSelectDTO> getRegisterDateProductList() {return mainDAO.findAllRegisterDateProduct(); }

    @Override
    public List<PostDTO> getLatestDateCommunityList() {
        return mainDAO.findAllLatestDateCommunity();
    }

    @Override
    public List<PostImgVO> findAllByPostId(Long postId) {
        return mainDAO.readAllByPostId(postId);
    }
}
