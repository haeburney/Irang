package Tlog_comment;

import java.util.ArrayList;

public class TCommentService {
	private TCommentDao dao;

	// 1. 한 줄 추가

	public void addComment(TCommentVo vo) {
		dao.insert(vo);
	}

	// 2-1. commentNum 으로 검색
	public TCommentVo getCommentByNum(int num) {
		return dao.selectByNum(num);
	}

	// 2-2. teacherlogNum 으로 검색 -- 선생님 일지 밑에 해당 일지 코멘트 전체 출력
	public ArrayList<TCommentVo> getCommentByLog(int num) {
		return dao.selectByLog(num);
	}

	// 3. 전체 검색
	public ArrayList<TCommentVo> getAllComment() {
		return dao.selectAll();
	}

	// 4. content 수정
	public void editComment(TCommentVo vo) {
		dao.update(vo);
	}

	// 5. 삭제
	public void delComment(int num) {
		dao.delete(num);
	}

}
