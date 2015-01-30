package org.inv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.beans.DBbean;
import org.beans.PrintInv;

public class PrintInvDAOimpl implements PrintInvDAO {

	public PrintInv getPrintInv(String id){
		InvoiceDAOimpl invdao=new InvoiceDAOimpl();
		
		String sql="SELECT  * FROM invoice.ds_invoices as  d inner JOIN invoice.ds_customers as " +
					"cus on d.customer_id=cus.id "+
					"Inner JOIN invoice.ds_biller as bil "+
					" on d.biller_id=bil.id "+
					" inner join invoice.ds_preferences as pref "+
					" on d.preference_id=pref.pref_id "+
					" where d.id='"+id+"'";
		
		
		ResultSet rs=null;
		PrintInv pv=new PrintInv();
		pv.setItem_list(invdao.getItemsByInv(id));
		try {
	DBbean.connect();
	rs=DBbean.execSQL(sql);
InvoiceDAOimpl inv=new InvoiceDAOimpl();
inv.getAllinv();
	while(rs.next()){
//get from property file
		pv.setFrom("Sanjay");
		pv.setInv_company("ABC cmpny");
		pv.setFrom_add("795 Folsom Ave, Suite 600"+"\n San Francisco, CA 94107");
		pv.setTo(rs.getString("name"));
		pv.setTo_add(rs.getString("street_address")+"\n"+rs.getString("city")+"\n"+rs.getString("state")+"\n"+rs.getString("phone")+"\n"+rs.getString("email"));
		pv.setDateofInv(rs.getString("date"));
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 

		
		return pv;
	}
}
