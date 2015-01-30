package org.inv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.beans.Cart;
import org.beans.DBbean;
import org.beans.InvoiceItems;
import org.beans.invoice;
import org.logg.RunInvLogger;
import org.utils.MyUtils;

public class InvoiceDAOimpl implements InvoiceDAO {

	@Override
	public boolean AddInv(invoice inv) {
		
		boolean insertV=false;
		int y=0;
		String Sql="INSERT INTO ds_invoices (id, domain_id, biller_id, customer_id, type_id, preference_id, date, " +
				        "custom_field1, custom_field2, custom_field3, custom_field4, note)" +
						" VALUES('"+inv.getInvId()+"', 1, '"+inv.getBillerId()+"'," +"'"+inv.getCustId()+"'," +
						 "'"+inv.getTypId()+"', '"+inv.getInvPreferenceID()+"', '"+inv.getDate()+"', '"+new Date().toString()+"', NULL, NULL, NULL, '"+inv.getNote()+"')";
		
		RunInvLogger.getbaseLogger().debug("SQL Executed for Add Inv is "+Sql);
		
		try {
			
			DBbean.connect();
			y=DBbean.updateSQL(Sql);
			
		insertV=y>0?true:false;
		
		RunInvLogger.getbaseLogger().info("Insert Is "+insertV+"for "+this.getClass().toString());
		
		} catch (ClassNotFoundException e) {
			RunInvLogger.getbaseLogger().trace(e.toString().toString());
			RunInvLogger.getbaseLogger().debug(e.getLocalizedMessage().toString());
			RunInvLogger.getbaseLogger().error(e);
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().warn(e);
			RunInvLogger.getbaseLogger().error(e);
		}
	
		finally{
			
			DBbean.close();
		}
		
		return insertV;
	}

	@Override
	public invoice getInvByID(int id) {
		String Sql="SELECT * FROM invoice.ds_invoices where id='"+id+"' ";
		ResultSet rs=null;
		invoice in=new invoice();
		try {
			DBbean.connect();
			rs=DBbean.execSQL(Sql);
			if(rs.next()){
				in.setCustId(MyUtils.convtoInt(rs.getString("customer_id")));
				in.setBillerId(MyUtils.convtoInt(rs.getString("biller_id")));
				in.setDate(rs.getString("date"));
				in.setInvPreferenceID(MyUtils.convtoInt(rs.getString("preference_id")));
				in.setTypId(MyUtils.convtoInt(rs.getString("type_id")));
				in.setNote(rs.getString("note"));
				
							}
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().warn(e);
			RunInvLogger.getbaseLogger().error(e);
		} 
		
		
	
		
		return in;
	}

	@Override
	public ArrayList<invoice> getAllinv() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean EditInv(invoice inv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delInv(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean invoiceitemAdd(String User, String Session,int invID) {
		
		int count=0;
		CartDAOimpl cartDao=new CartDAOimpl();
		ArrayList<Cart> allList=cartDao.getbyUserandSession(User, Session);
		try {
			DBbean.connect();
		
			for(int i=0;i<allList.size();i++){
			///need batch update
				Cart cs=new Cart();
				cs=allList.get(i);
				String sql="INSERT INTO ds_invoice_items (id, invoice_id, quantity, product_id, unit_price, tax_id, tax,user, tax_amount, gross_total, description, total) VALUES"
				+"('"+new Random().nextInt(100)+"', '"+invID+"', '"+MyUtils.convtoInt(cs.getQty())+"', '"+cs.getProd_id()+"', '"+MyUtils.convtoDouble(cs.getUnit_price())+"', " +
						"'"+cs.getTax_id()+"', '"+cs.getTax()+"', '"+cs.getUser()+"', '"+MyUtils.convtoDouble(cs.getTotal())+"','"+MyUtils.convtoDouble(cs.getTotal())+"','"+new Date().toString()+"','"+cs.getTotal()+"')";
	
				
				RunInvLogger.getbaseLogger().info("Executing Inside invoiceitemadd"+sql+"Inside class :"+this.getClass().getName().toString());
			
				
				
			DBbean.connect();
			DBbean.updateSQL(sql);
			
			DBbean.close();
			
			
			}
			
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().warn(e);
			RunInvLogger.getbaseLogger().error(e);
			count=0;
		} 
		
return true;
		
	}
	
	
	public boolean decreaseQuanty(String id ,String qty){
		RunInvLogger.getbaseLogger().info(qty);
		return true;
	}
	
	
	public ArrayList<InvoiceItems> getItemsByInv(String invId)  {
		
		
		ArrayList<InvoiceItems> invitm=new ArrayList<InvoiceItems>();
	String sql="SELECT * FROM invoice.ds_invoice_items itm inner join invoice.ds_products pro on itm.product_id=pro.id inner join invoice.ds_tax tax on itm.tax_id=tax.tax_id inner join invoice.ds_invoices inv on inv.id=itm.invoice_id where itm.invoice_id='"+invId+"'  ";
	
	RunInvLogger.getbaseLogger().info(sql);
	ResultSet rs=null;
	try {
		DBbean.connect();
		rs=DBbean.execSQL(sql);
		while(rs.next()){
			
			InvoiceItems inv=new InvoiceItems();
			inv.setProductName(rs.getString("description"));
			inv.setUnitPrice(MyUtils.convtoDouble(rs.getString("unit_price")));
			inv.setQty(MyUtils.convtoInt(rs.getString("quantity")));
			inv.setTotal(MyUtils.convtoDouble(rs.getString("gross_total")));
		
			invitm.add(inv);
		}
	} catch (Exception e) {
		RunInvLogger.getbaseLogger().warn(e);
		RunInvLogger.getbaseLogger().error(e);
	} 
	finally{
	//	rs.close();
		DBbean.close();
	}
	
		return invitm;
	}
	
	
	
}
