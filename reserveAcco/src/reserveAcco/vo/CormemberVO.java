package reserveAcco.vo;

public class CormemberVO {
	private String corId;
	private String corNo;
	private String corPass;
	private String corName;
	private String corTel;
	
	public CormemberVO() {}
	
	public CormemberVO(String corId, String corNo, String corPass, String corName, String corTel) {
		this.corId = corId;
		this.corNo = corNo;
		this.corPass = corPass;
		this.corName = corName;
		this.corTel = corTel;
	}
	
	public String getCorId() {
		return corId;
	}
	public void setCorId(String corId) {
		this.corId = corId;
	}
	public String getCorNo() {
		return corNo;
	}
	public void setCorNo(String corNo) {
		this.corNo = corNo;
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
		return "CormemberVO [corId=" + corId + ", corNo=" + corNo + ", corPass=" + corPass + ", corName=" + corName
				+ ", corTel=" + corTel + "]";
	}

}	// end of class
