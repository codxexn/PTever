package com.app.ptever.repository;

import com.app.ptever.dao.CommunityCommentDAO;
import com.app.ptever.domain.dto.CommunityCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CommunityCommentServiceImpl implements CommunityCommentService {
    private final CommunityCommentDAO communityCommentDAO;


    @Override
    public List<CommunityCommentDTO> findAllByPostId(Long postId) {
        return communityCommentDAO.readAllByPostId(postId);
    }

    @Override
    public void saveComment(CommunityCommentDTO communityCommentDTO) {
        communityCommentDAO.writeComment(communityCommentDTO);
    }

    @Override
    public void discardComment(Long communityCommentId) {
        communityCommentDAO.removeComment(communityCommentId);
    }
}
