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
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CommunityServiceImpl implements CommunityService {
    private final CommunityDAO communityDAO;
    @Override
    public List<PostDTO> findAll() {
        return communityDAO.readAll();
    }

    @Override
    public Optional<PostDTO> findByPostId(Long postId) {
        return communityDAO.readByPostId(postId);
    }

    @Override
    public List<PostDTO> findAllByCommunityId(Long communityId) {
        return communityDAO.readAllByCommunityId(communityId);
    }

    @Override
    public List<PostDTO> findAllByUserId(Long userId) {
        return communityDAO.readAllByUserId(userId);
    }

    @Override
    public void discardByPostId(Long postId) {
        communityDAO.removeByPostId(postId);
    }

    @Override
    public void discardCommentByPostId(Long postId) {
        communityDAO.removeCommentByPostId(postId);
    }

    @Override
    public void saveFreePost(PostDTO postDTO) {
        communityDAO.writeFreePost(postDTO);
    }

    @Override
    public void saveTransPost(PostDTO postDTO) {
        communityDAO.writeTransPost(postDTO);
    }

    @Override
    public void revisePost(PostDTO postDTO) {
        communityDAO.modifyPost(postDTO);
    }
}
