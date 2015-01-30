package org.beans;

public class InvoiceItems {
String productName;
double unitPrice;
int Qty;
String tax_id;
String tax_name;
String taxPercent;

double total;

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public double getUnitPrice() {
	return unitPrice;
}

public void setUnitPrice(double unitPrice) {
	this.unitPrice = unitPrice;
}

public int getQty() {
	return Qty;
}

public void setQty(int qty) {
	Qty = qty;
}

public String getTax_id() {
	return tax_id;
}

public void setTax_id(String tax_id) {
	this.tax_id = tax_id;
}

public String getTax_name() {
	return tax_name;
}

public void setTax_name(String tax_name) {
	this.tax_name = tax_name;
}

public String getTaxPercent() {
	return taxPercent;
}

public void setTaxPercent(String taxPercent) {
	this.taxPercent = taxPercent;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}



}
