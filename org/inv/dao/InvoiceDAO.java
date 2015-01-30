package org.inv.dao;

import java.util.ArrayList;

import org.beans.Cart;
import org.beans.invoice;

public interface InvoiceDAO {

	
	public boolean AddInv(invoice inv);
	public invoice getInvByID(int id);
	public ArrayList<invoice> getAllinv();
	public boolean EditInv(invoice inv);
	public boolean delInv(int id);
	public boolean invoiceitemAdd(String User,String Session,int InvId);
	
	
}
