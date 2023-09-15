package src.ppt4;

public class MainClass {

	public static void main(String[] args) {
		
		DepartmentClass RnD = new DepartmentClass("RnD");	
		RnD.addEmployee("정숙", "수석연구원");
		RnD.addEmployee("옥순", "책임연구원");
		RnD.addEmployee("순자", "주임연구원");
		RnD.addEmployee("영숙", "사원연구원");
		RnD.addEmployee("영자", "사원연구원");		
		RnD.printEmployeeList();		
		System.out.println("===================================");
		
		// 직급 변경
		RnD.changePosition("옥순", "책임연구원", "선임연구원");		
		RnD.printEmployeeList();
		System.out.println("===================================");
		
		DepartmentClass Sales = new DepartmentClass("Sales");
		Sales.addEmployee("상철", "사장");
		Sales.addEmployee("영호", "부사장");
		Sales.addEmployee("영식", "과장");
		Sales.addEmployee("영철", "대리");
		Sales.addEmployee("광수", "사원");
		Sales.printEmployeeList();
		System.out.println("===================================");
	}

}
