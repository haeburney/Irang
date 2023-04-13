package Chlog_comment;

import java.util.ArrayList;

public class ChCommentService {
	private ChCommentDao dao;

	// 1. 한 줄 추가

	public void addComment(ChCommentVo vo) {
		dao.insert(vo);
	}

	// 2-1. commentNum 으로 검색
	public ChCommentVo getCommentByNum(int num) {
		return dao.selectByNum(num);
	}

	// 2-2. childlogNum 으로 검색 -- 아이 일지 밑에 해당 일지 코멘트 전체 출력
	public ArrayList<ChCommentVo> getCommentByLog(int num) {
		return dao.selectByLog(num);
	}

	// 3. 전체 검색
	public ArrayList<ChCommentVo> getAllComment() {
		return dao.selectAll();
	}

	// 4. content 수정
	public void editComment(ChCommentVo vo) {
		dao.update(vo);
	}

	// 5. 삭제
	public void delComment(int num) {
		dao.delete(num);
	}

}
