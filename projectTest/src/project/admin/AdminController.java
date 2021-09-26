package project.admin;

public class AdminController {
	// �̱��� ����
	private static AdminController instance = new AdminController();
	public static AdminController getInstance() {
		return instance;
	}
	private AdminController() {}
	
	// ���� ��ü ����
	private AdminService adminservice = AdminService.getInstance();
	
	public AdminVO findAdmin(String adminId) {
		return adminservice.findAdmin(adminId);
	}
}	// end of class
