package project.admin;

public class AdminController {
	// 싱글톤 패턴
	private static AdminController instance = new AdminController();
	public static AdminController getInstance() {
		return instance;
	}
	private AdminController() {}
	
	// 서비스 객체 생성
	private AdminService adminservice = AdminService.getInstance();
	
	public AdminVO findAdmin(String adminId) {
		return adminservice.findAdmin(adminId);
	}
}	// end of class
