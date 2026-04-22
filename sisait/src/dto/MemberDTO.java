package dto;

public class MemberDTO {
	private int m_no;
	private String name;
	private String tel;
	private String email;
	private String gender;
	private String birthdate;
	private String writedate;

	public MemberDTO() {}
		public MemberDTO(String name, String tel, String gender) {
			this.name = name;
			this.tel = tel;
			this.gender = gender;
		}
		public MemberDTO(String name, String tel, String email, String gender, String birthdate) {
			this.name = name;
			this.tel = tel;
			this.email = email;
			this.gender = gender;
			this.birthdate = birthdate;
		}
		@Override
		public String toString() {
			return m_no + "\t" + name + "\t" + tel + "\t" + email + "\t" + gender + "\t" + birthdate + "\t" + writedate;
		}
		public int getM_no() {
			return m_no;
		}
		public void setM_no(int m_no) {
			this.m_no = m_no;
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
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getBirthdate() {
			return birthdate;
		}
		public void setBirthdate(String birthdate) {
			this.birthdate = birthdate;
		}
		public String getWritedate() {
			return writedate;
		}
		public void setWritedate(String writedate) {
			this.writedate = writedate;
		}
	

}
