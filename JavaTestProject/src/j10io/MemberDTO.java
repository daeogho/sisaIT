package j10io;

import java.io.Serializable;

// DTO : data table Object
// VO : value object
public class MemberDTO implements Serializable { // 파일로 기록이 가능한 클래스는 직렬화가 되어야한다.
	// 번호, 이름, 연락처, 이메일, 주소
	private int num;
	private String name;
	private String tel;
	private String email;
	private String addr;

	public MemberDTO() {
	}

	public MemberDTO(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;

	}

	public MemberDTO(int num, String name, String tel, String email, String addr) {
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.addr = addr;

	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + ", email=" + email + ", addr=" + addr + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
