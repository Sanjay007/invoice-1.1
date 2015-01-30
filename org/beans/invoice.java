package org.beans;

public class invoice {

	
	int invId;
	int billerId;
	int custId;
	int typId;
	String date ;
	String Note;
	int domId;
	int invPreferenceID;
	
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
	}
	public int getBillerId() {
		return billerId;
	}
	public void setBillerId(int billerId) {
		this.billerId = billerId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getTypId() {
		return typId;
	}
	public void setTypId(int typId) {
		this.typId = typId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public int getDomId() {
		return domId;
	}
	public void setDomId(int domId) {
		this.domId = domId;
	}
	public int getInvPreferenceID() {
		return invPreferenceID;
	}
	public void setInvPreferenceID(int invPreferenceID) {
		this.invPreferenceID = invPreferenceID;
	}
	
	
	
}
