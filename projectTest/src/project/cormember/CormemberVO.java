package project.cormember;

public class CormemberVO {
	private String corNo;
	private String corId;
	private String corPass;
	private String corName;
	private String corTel;
	
	public String getCorNo() {
		return corNo;
	}
	public void setCorNo(String corNo) {
		this.corNo = corNo;
	}
	public String getCorId() {
		return corId;
	}
	public void setCorId(String corId) {
		this.corId = corId;
	}
	public String getCorPass() {
		return corPass;
	}
	public void setCorPass(String corPass) {
		this.corPass = corPass;
	}
	public String getCorName() {
		return corName;
	}
	public void setCorName(String corName) {
		this.corName = corName;
	}
	public String getCorTel() {
		return corTel;
	}
	public void setCorTel(String corTel) {
		this.corTel = corTel;
	}
	@Override
	public String toString() {
		return "CormemberVO [corNo=" + corNo + ", corId=" + corId + ", corPass=" + corPass + ", corName=" + corName
				+ ", corTel=" + corTel + "]";
	}
}	// end of class
