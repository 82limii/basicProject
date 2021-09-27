package reserveAcco.vo;

public class AccoVO {
	private String accoId;
	private String accoName;
	private String accoAdd;
	private String accoTel;
	private String accoIntro;
	private String corId;
	
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
	public String getAccoIntro() {
		return accoIntro;
	}
	public void setAccoIntro(String accoIntro) {
		this.accoIntro = accoIntro;
	}
	public String getCorId() {
		return corId;
	}
	public void setCorId(String corId) {
		this.corId = corId;
	}
	@Override
	public String toString() {
		return "AccoVO [accoId=" + accoId + ", accoName=" + accoName + ", accoAdd=" + accoAdd + ", accoTel=" + accoTel
				+ ", accoIntro=" + accoIntro + ", corId=" + corId + "]";
	}
	
}	// end of class
