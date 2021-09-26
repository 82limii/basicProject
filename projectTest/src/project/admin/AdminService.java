package project.admin;

public class AdminService {
	// ΩÃ±€≈Ê ∆–≈œ
	private static AdminService instance = new AdminService();
	public static AdminService getInstance() {
		return instance;
	}
	private AdminService() {}
	
	// DAO
	private AdminDao adminDao = AdminDao.getInstance();
	
	public AdminVO findAdmin(String adminId) {
		return adminDao.findAdmin(adminId);
	}
}	// end of class
