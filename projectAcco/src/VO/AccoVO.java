package VO;

public class AccoVO {
	private String accoId;
	private String accoName;
	private String accoAdd;
	private String accoTel;
	private double accoRate;
	private String accoFacility;
	private String accoIntro;
	private String corNo;
	
	public String getAccoId() {
		return accoId;
	}
	public void setAccoId(String accoId) {
		this.accoId = accoId;
	}
	public String getAccoName() {
		return accoName;
	}
	public void setAccoName(String accoName) {
		this.accoName = accoName;
	}
	public String getAccoAdd() {
		return accoAdd;
	}
	public void setAccoAdd(String accoAdd) {
		this.accoAdd = accoAdd;
	}
	public String getAccoTel() {
		return accoTel;
	}
	public void setAccoTel(String accoTel) {
		this.accoTel = accoTel;
	}
	public double getAccoRate() {
		return accoRate;
	}
	public void setAccoRate(double accoRate) {
		this.accoRate = accoRate;
	}
	public String getAccoFacility() {
		return accoFacility;
	}
	public void setAccoFacility(String accoFacility) {
		this.accoFacility = accoFacility;
	}
	public String getAccoIntro() {
		return accoIntro;
	}
	public void setAccoIntro(String accoIntro) {
		this.accoIntro = accoIntro;
	}
	public String getCorNo() {
		return corNo;
	}
	public void setCorNo(String corNo) {
		this.corNo = corNo;
	}
	@Override
	public String toString() {
		return "AccoVO [accoId=" + accoId + ", accoName=" + accoName + ", accoAdd=" + accoAdd + ", accoTel=" + accoTel
				+ ", accoRate=" + accoRate + ", accoFacility=" + accoFacility + ", accoIntro=" + accoIntro + ", corNo="
				+ corNo + "]";
	}
	
	
	
}
