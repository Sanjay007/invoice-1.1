package org.inv.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import org.beans.DBbean;
import org.beans.Payment;
import org.logg.RunInvLogger;
import org.utils.MyUtils;

public class PaymentDAOimpl implements PaymentDAO {

	@Override
	public boolean addDefaultPay(Payment pmt) {
		int result=0;
		RunInvLogger.getbaseLogger().info("Entering PaymentDAOimpl->addDefaultPay");
		System.out.println(pmt.getPaymentType()+"yyyy");
		String sql="INSERT INTO ds_payment (id, ac_inv_id, ac_amount, ac_notes,ac_date,ac_payment_type,domain_id,online_payment_id) values" +
				"							('"+new Random().nextInt(1000)+"','"+pmt.getInv_id()+"','"+pmt.getAmount()+"','Default Payment','"+MyUtils.getTodaysdate()+"','"+pmt.getPaymentType()+"','1','Not Available')";
		RunInvLogger.getbaseLogger().debug("Executing SQL: "+sql);
		
		try {
			DBbean.connect();
			result=DBbean.updateSQL(sql);
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().warn(e);
			RunInvLogger.getbaseLogger().error(e);
		}
		finally{
			
			DBbean.close();
		}
		RunInvLogger.getbaseLogger().info("Exit PaymentDAOimpl->addDefaultPay");
		return (result>0)?true:false;
	}

	
	

}
