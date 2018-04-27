package com.yedam.app.sugt;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.sugt.CommentsVO;

@Service
public interface CommentsService {

	public void insertComments(CommentsVO vo);
	public void updateComments(CommentsVO vo);
	public void deleteComments(CommentsVO vo);
	public List<CommentsVO> getCommentsList(CommentsVO vo);
	public CommentsVO getComments(CommentsVO vo);
}
