package kclass;

public class ClassVo {
	private int class_num;
	private String class_name;

	public ClassVo() {
	}

	public ClassVo(int class_num, String class_name) {
		super();
		this.class_num = class_num;
		this.class_name = class_name;
	}

	public int getClass_num() {
		return class_num;
	}

	public void setClass_num(int class_num) {
		this.class_num = class_num;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	@Override
	public String toString() {
		return "ClassVo [class_num=" + class_num + ", class_name=" + class_name + "]";
	}

}
