package project.event;

import java.util.Date;

public class EventVO {
	private int eveNo; // 이벤트 코드
	private String eveName; // 이벤트 명  
	private Date eveStart; // 게시날짜 
	private Date eveEnd;  // 종료날짜 
	private String eveInfo;  // 설명 
	private int eveDis;  // 할인율
	
	public EventVO(int eveNo,String eveName,Date eveStart,Date eveEnd,String eveInfo,int eveDis){
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

	public Date getEveStart() {
		return eveStart;
	}

	public void setEveStart(Date eveStart) {
		this.eveStart = eveStart;
	}

	public Date getEveEnd() {
		return eveEnd;
	}

	public void setEveEnd(Date eveEnd) {
		this.eveEnd = eveEnd;
	}

	public String getEveInfo() {
		return eveInfo;
	}

	public void setEveInfo(String eveInfo) {
		this.eveInfo = eveInfo;
	}

	public int getEveDis() {
		return eveDis;
	}

	public void setEveDis(int eveDis) {
		this.eveDis = eveDis;
	}

	@Override
	public String toString() {
		return "EventVO [eveNo=" + eveNo + ", eveName=" + eveName + ", eveStart=" + eveStart + ", eveEnd=" + eveEnd
				+ ", eveInfo=" + eveInfo + ", eveDis=" + eveDis + "]";
	}

}
