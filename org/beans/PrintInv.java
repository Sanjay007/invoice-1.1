package org.beans;

import java.util.ArrayList;

public class PrintInv {

	
	String from;
	String to;
	String from_add;
	String to_add;
	String inv_company;
	String tag_name;
	String tag_value;
	ArrayList<InvoiceItems> item_list;
	String DateofInv;
	String paydue;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom_add() {
		return from_add;
	}
	public void setFrom_add(String from_add) {
		this.from_add = from_add;
	}
	public String getTo_add() {
		return to_add;
	}
	public void setTo_add(String to_add) {
		this.to_add = to_add;
	}
	public String getInv_company() {
		return inv_company;
	}
	public void setInv_company(String inv_company) {
		this.inv_company = inv_company;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getTag_value() {
		return tag_value;
	}
	public void setTag_value(String tag_value) {
		this.tag_value = tag_value;
	}
	public ArrayList<InvoiceItems> getItem_list() {
		return item_list;
	}
	public void setItem_list(ArrayList<InvoiceItems> item_list) {
		this.item_list = item_list;
	}
	public String getDateofInv() {
		return DateofInv;
	}
	public void setDateofInv(String dateofInv) {
		DateofInv = dateofInv;
	}
	public String getPaydue() {
		return paydue;
	}
	public void setPaydue(String paydue) {
		this.paydue = paydue;
	}

}
