package project.member;

import java.sql.Date;

public class MemberVO {
	private String memId;
	private String memPass;
	private String memName;
	private Date memBir;
	private String memNick;
	private String memTel;
	private int memMileage;
	
	public MemberVO() {
	}
	
	public MemberVO(String memId, String memPass) {
		this.memId = memId;
		this.memPass = memPass;
	}

	public MemberVO(String memId, String memPass, String memName, Date memBir, String memNick, String memTel,
			int memMileage) {
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memBir = memBir;
		this.memNick = memNick;
		this.memTel = memTel;
		this.memMileage = memMileage;
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
	public Date getMemBir() {
		return memBir;
	}
	public void setMemBir(Date memBir) {
		this.memBir = memBir;
	}
	public String getMemNick() {
		return memNick;
	}
	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public int getMemMileage() {
		return memMileage;
	}
	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}
	
	public void invalidate() {
		this.memId = null;
		this.memPass = null;
		this.memName = null;
		this.memBir = null;
		this.memNick = null;
		this.memTel = null;
		this.memMileage = 0;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memBir=" + memBir
				+ ", memNick=" + memNick + ", memTel=" + memTel + ", memMileage=" + memMileage + "]";
	}
	
}
