package project.admin;

public class AdminController {
	// ½Ì±ÛÅæ ÆÐÅÏ
	private static AdminController instance = new AdminController();
	public static AdminController getInstance() {
		return instance;
	}
	private AdminController() {}
	
	// ¼­ºñ½º °´Ã¼ »ý¼º
	private AdminService adminservice = AdminService.getInstance();
	
	public AdminVO findAdmin(String adminId) {
		return adminservice.findAdmin(adminId);
	}
}	// end of class
