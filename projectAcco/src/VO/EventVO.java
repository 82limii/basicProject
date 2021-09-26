package VO;

import java.util.Date;
public class EventVO {
	private int eveNo; // �̺�Ʈ �ڵ�
	private String eveName; // �̺�Ʈ ��  
	private Date eveStart; // �Խó�¥ 
	private Date eveEnd;  // ���ᳯ¥ 
	private String eveInfo;  // ���� 
	private int eveDis;  // ������
	
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

