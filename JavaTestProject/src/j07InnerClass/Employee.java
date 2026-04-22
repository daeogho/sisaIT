package j07InnerClass;

public class Employee {
	// 캡슐화
	private int empNo = 202501;
	private String empName = "이순신";
	private String position = "과장";
	public Employee() {}
	
	@Override
	public String toString() {
		return "empNo=" + empNo + ", empName=" + empName + ", position=" + position;
	}
	
	// getter, setter

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
