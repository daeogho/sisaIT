package dto;

public class LbUserDTO {

	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_tel;
	private String user_birth;

	public LbUserDTO() {
	}

	public LbUserDTO(String user_id, String user_pw, String user_name, String user_tel, String user_birth) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_tel = user_tel;
		this.user_birth = user_birth;
		
	}

	@Override
	public String toString() {
		return user_id + "\t" + user_pw + "\t" + user_name + "\t" +  user_tel + "\t" + user_birth;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

}
