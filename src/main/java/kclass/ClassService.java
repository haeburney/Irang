package kclass;

import java.util.ArrayList;

public class ClassService {
	ClassDao dao = new ClassDao();

	public void addVo(ClassVo vo) {
		dao.insert(vo);
	}

	public ClassVo getByNum(int num) {
		return dao.selectByNum(num);
	}
	
	public ArrayList<ClassVo> getByName(String name) {
		return dao.selectByName(name);
	}

	public ArrayList<ClassVo> getAll() {
		return dao.selectAll();
	}

	public void editVo(ClassVo vo) {
		dao.update(vo);
	}

	public void delVo(int num) {
		dao.delete(num);
	}
}
