package project.event;

public class EventVO {
	private int eveNo; // 이벤트 코드
	private String eveName; // 이벤트 명  
	private String eveStart; // 게시날짜("2021-09-21") 
	private String eveEnd;  // 종료날짜("2021-09-21")
	private String eveInfo;  // 설명 
	private double eveDis;  // 할인율
	
	public EventVO() {}
	
	public EventVO(int eveNo,String eveName,String eveStart,String eveEnd,String eveInfo,int eveDis){
		super();
		this.eveNo = eveNo;
		this.eveName = eveName;
		this.eveStart = eveStart;
		this.eveEnd = eveEnd; 
		this.eveInfo = eveInfo;
		this.eveDis = eveDis;
		}

	public int getEveNo() {
		return eveNo;
	}

	public void setEveNo(int eveNo) {
		this.eveNo = eveNo;
	}

	public String getEveName() {
		return eveName;
	}

	public void setEveName(String eveName) {
		this.eveName = eveName;
	}

	public String getEveStart() {
		return eveStart;
	}

	public void setEveStart(String eveStart) {
		this.eveStart = eveStart;
	}

	public String getEveEnd() {
		return eveEnd;
	}

	public void setEveEnd(String eveEnd) {
		this.eveEnd = eveEnd;
	}

	public String getEveInfo() {
		return eveInfo;
	}

	public void setEveInfo(String eveInfo) {
		this.eveInfo = eveInfo;
	}

	public double getEveDis() {
		return eveDis;
	}

	public void setEveDis(double eveDis) {
		this.eveDis = eveDis;
	}

	@Override
	public String toString() {
		return "이벤트 코드 : " + eveNo + ", 이벤트명 : " + eveName + ", 게시날짜 : " + eveStart + ", 종료날짜 : " + eveEnd
				+ ", 설명 : " + eveInfo + ", 할인율 : " + eveDis + "]";
	}

}
