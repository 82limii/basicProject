package reserveAcco.vo;

public class CormemberVO {
	private String corNo;
	private String corId;
	private String corPass;
	private String corName;
	private String corTel;
	
	public CormemberVO() {
	}
	
	public CormemberVO(String corNo, String corId, String corPass, String corName, String corTel) {
		this.corNo = corNo;
		this.corId = corId;
		this.corPass = corPass;
		this.corName = corName;
		this.corTel = corTel;
	}
	
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
	
	public void invalidate() {
		this.corNo = null;
		this.corId = null;
		this.corPass = null;
		this.corName = null;
		this.corTel = null;
	}
	
	@Override
	public String toString() {
		return "CormemberVO [corNo=" + corNo + ", corId=" + corId + ", corPass=" + corPass + ", corName=" + corName
				+ ", corTel=" + corTel + "]";
	}
}	// end of class
