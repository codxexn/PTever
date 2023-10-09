package com.app.ptever.repository;

import com.app.ptever.dao.PostImgDAO;
import com.app.ptever.domain.vo.PostImgVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostImgServiceImpl implements PostImgService {
    private final PostImgDAO postImgDAO;

    @Override
    public List<PostImgVO> findAllByPostId(Long postId) {
        return postImgDAO.readAllByPostId(postId);
    }

    @Override
    public void saveImg(PostImgVO postImgVO) {
        postImgDAO.writeImg(postImgVO);
    }

    @Override
    public void reviseImg(PostImgVO postImgVO) {
        postImgDAO.modifyImg(postImgVO);
    }
}
