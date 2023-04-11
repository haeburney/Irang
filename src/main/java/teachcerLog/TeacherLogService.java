package teachcerLog;

import java.util.ArrayList;

public class TeacherLogService {
	private TeacherLogDao dao;

	public TeacherLogService() {
		dao = new TeacherLogDao();
	}

	// 선생님 일지 추가 (날짜 선생님이 선택)
	public void tlInsert(TeacherLogVo vo) {
		dao.insertAll(vo);
	}
	
	// 선생님 일지 추가 (오늘 날짜)
	public void tlInsertToday(TeacherLogVo vo) {
		dao.insertToday(vo);
	}

	// 활동, 건강 수정
	public void tlUpdateAll(TeacherLogVo vo) {
		dao.updateAll(vo);
	}

	// 활동만 수정
	public void tlUpdateActivity(TeacherLogVo vo) {
		dao.updateActivity(vo);
	}

	// 건강만 수정
	public void tlUpdateHealth(TeacherLogVo vo) {
		dao.updateHealth(vo);
	}

	// 전체 출력
	public ArrayList<TeacherLogVo> tlAll() {
		return dao.seleteAll();
	}

	// 일지 삭제
	public void tlDelete(int num) {
		dao.delete(num);
	}

	// child_id로 검색
	public ArrayList<TeacherLogVo> tlChildSelectId(String id) {
		return dao.selectChildId(id);
	}

	// teacher_id로 검색
	public ArrayList<TeacherLogVo> tlTeacherSelectId(String id) {
		return dao.selectTeacherId(id);
	}
}
