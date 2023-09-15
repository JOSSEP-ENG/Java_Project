package src.ppt4;

public class DepartmentClass {
	
	private String department;
	public int num = 0;	
	public EmployeeClass[] member;
	
	public DepartmentClass() {
		member = new EmployeeClass[100];
	}
	public DepartmentClass(String name) {
		this.department = name;
		member = new EmployeeClass[100];
	}
	
	// 부서 이름 설정
	public void setDepartmentName(String name) {
		this.department = name;
	}
	
	// 부서 이름 반환
	public String getDepartmentName() {
		return this.department;
	}
	
	// 사원 추가
	public void addEmployee(String name, String position) {
		member[++num] = new EmployeeClass(name, position);
	}
	
	// 직급 변경
	public void changePosition(String name, String original, String newPosition) {
		for(int i = 1; i <= num; i++) {
			if(member[i].employee.equals(name)) {
				if(member[i].position.equals(original)) {
					member[i].position = newPosition;					
				}				
			}
		}
	}
	
	// 전체 사원 리스트 출력
	public void printEmployeeList() {
		for(int i = 1; i <= num; i++) {
			System.out.printf("%d.사원이름: %s, 직급: %s\n"
					,i,member[i].getEmployeeName(),member[i].getEmployeePosition());
		}
	}
	
	/*부서->사원 (내부클래스)*/
	public class EmployeeClass {
		private String employee;
		private String position;
		
		public EmployeeClass() {}
		public EmployeeClass(String name, String position) {			
			this.employee = name;
			this.position = position;			
		}
		
		// 사원 이름 설정
		public void setEmployeeName(String name) {
			this.employee = name;
		}
		
		// 사원 직급 설정
		public void setEmployeePosition(String position) {
			this.position = position;
		}
		
		// 사원 이름 반환
		public String getEmployeeName() {
			return this.employee;
		}
		// 사원 직급 반환
		public String getEmployeePosition() {
			return this.position;
		}			
	}		
}
