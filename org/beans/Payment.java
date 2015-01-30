package org.beans;

public class Payment {
int id;
int inv_id;
Double amount;
String payDate;
int paymentType;
String onlinpayID;
String strtDate;
String endDate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getInv_id() {
	return inv_id;
}
public void setInv_id(int inv_id) {
	this.inv_id = inv_id;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public String getPayDate() {
	return payDate;
}
public void setPayDate(String payDate) {
	this.payDate = payDate;
}
public int getPaymentType() {
	return paymentType;
}
public void setPaymentType(int paymentType) {
	this.paymentType = paymentType;
}
public String getOnlinpayID() {
	return onlinpayID;
}
public void setOnlinpayID(String onlinpayID) {
	this.onlinpayID = onlinpayID;
}
public String getStrtDate() {
	return strtDate;
}
public void setStrtDate(String strtDate) {
	this.strtDate = strtDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}


}
