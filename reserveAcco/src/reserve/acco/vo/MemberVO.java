package reserve.acco.vo;


public class MemberVO {
	private String memId;
	private String memPass;
	private String memName;
	private String memBir;
	private String memTel;
	
	public MemberVO() {
	}
	
	public MemberVO(String memId, String memPass, String memName, String memBir, String memTel) {
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memBir = memBir;
		this.memTel = memTel;
	}
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemBir() {
		return memBir;
	}
	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	
	@Override
	public String toString() {
		return "개인ID : " + memId + ", 개인 비밀번호 : " + memPass + ", 이름 : " + memName + ", 생년월일 : " + memBir
				+ ", 연락처 : " + memTel;
	}
	
}
