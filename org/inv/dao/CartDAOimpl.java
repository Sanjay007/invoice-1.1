package org.inv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.beans.Cart;
import org.beans.DBbean;
import org.logg.RunInvLogger;

public class CartDAOimpl implements CartDAO {

	@Override
	public boolean addCart(Cart Cart) {
		RunInvLogger.getbaseLogger().info("Entering CartDaoimpl->addCart");
		Random r=new Random();
		int y=r.nextInt(1000);
		boolean done=false;
		int res=0;
		String sql="INSERT INTO ds_cart (cart_id, session_id, user, product,qty,tax,unit_price,total,prod_id,tax_id) values('"+y+"','"+Cart.getSessionid()+"','"+Cart.getUser()+"','"+Cart.getProductname()+"','"+Cart.getQty()+"','"+Cart.getTax()+"','"+Cart.getUnit_price()+"','"+Cart.getTotal()+"','"+Cart.getProd_id()+"','"+Cart.getTax_id()+"')";
		try {
			DBbean.connect();
			res=DBbean.updateSQL(sql);
			if(res>0){
				done=true;
			}
		} catch (Exception e ) {
			
			RunInvLogger.getbaseLogger().info("Error Thrown ");
			RunInvLogger.getbaseLogger().warn(e);
			RunInvLogger.getbaseLogger().error(e);
			
	
			
		}
		
		finally{
			
			DBbean.close();
		}
		RunInvLogger.getbaseLogger().info("Exit CartDaoimpl->emptycart");
		return done;
	}

	private static boolean checkAlreadyexists(String user,String session,Cart cart ){
		
		
		return true;
		
	}
	
	@Override
	public ArrayList<Cart> getbyUserandSession(String user, String session) {
		RunInvLogger.getbaseLogger().info("Entering CartDaoimpl->getbyUserandSession");
		ArrayList<Cart> cartlist=new ArrayList<Cart>();
		String sql="select cart_id,session_id,user,product,sum(qty) as qty,tax,unit_price,sum(total) as total ,prod_id,tax_id from ds_cart where user='"+user+"' and session_id='"+session+"' group by product";
		RunInvLogger.getbaseLogger().info(sql);
		ResultSet rs=null;
		try {
			DBbean.connect();
			rs=DBbean.execSQL(sql);
			
				
			RunInvLogger.getbaseLogger().info("Retriving Cart Info ");
				while(rs.next()){
					Cart listcar=new Cart();
					listcar.setProductname(rs.getString("product"));
					listcar.setQty(rs.getString("qty"));
					listcar.setSessionid(rs.getString("session_id"));
					listcar.setTax(rs.getString("tax"));
					listcar.setTotal(rs.getString("total"));
					listcar.setUser(user);
					listcar.setUnit_price(rs.getString("unit_price"));
					listcar.setProd_id(rs.getInt("prod_id"));
					listcar.setTax_id(rs.getInt("tax_id"));
					
					cartlist.add(listcar);
				}
				
				System.out.println(cartlist.size());
			
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().warn(e);
			RunInvLogger.getbaseLogger().error(e);
			RunInvLogger.getbaseLogger().info(e.getLocalizedMessage());
		} 
		finally{DBbean.close();}
		
		RunInvLogger.getbaseLogger().info("Exit CartDaoimpl->getbyUserandSession");
		return cartlist;
		
	}

	@Override
	public ArrayList<Cart> getall() throws Exception {
		RunInvLogger.getbaseLogger().info("Entering CartDaoimpl->getall");
		
		ArrayList<Cart> cartlist=new ArrayList<Cart>();
		String sql="select * from ds_cart ";
		RunInvLogger.getbaseLogger().info(sql);
		ResultSet rs=null;
		try {
			DBbean.connect();
			rs=DBbean.execSQL(sql);
			
				
			RunInvLogger.getbaseLogger().info("Retriving All Cart Info ");
				while(rs.next()){
					Cart listcar=new Cart();
					listcar.setProductname(rs.getString("product"));
					listcar.setQty(rs.getString("qty"));
					listcar.setSessionid(rs.getString("session_id"));
					listcar.setTax(rs.getString("tax"));
					listcar.setTotal(rs.getString("total"));
					listcar.setUser(rs.getString("user"));
					listcar.setUnit_price(rs.getString("unit_price"));
					
					listcar.setProd_id(rs.getInt("prod_id"));
					listcar.setTax_id(rs.getInt("tax_id"));
					cartlist.add(listcar);
				}
				
				System.out.println(cartlist.size());
			
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().warn(e);
			RunInvLogger.getbaseLogger().error(e);
			
		} 
		finally{DBbean.close();}
		RunInvLogger.getbaseLogger().info("Exit CartDaoimpl->getall");
		return cartlist;
		
	}

	@Override
	public boolean emptyCart(String user,String session_id) {
		RunInvLogger.getbaseLogger().info("Entering CartDaoimpl->emptycart");
		
		int y=0;
		String SQl="delete from ds_cart where user='"+user+"' and session_id='"+session_id+"'";
		try {
			DBbean.connect();
			y=DBbean.updateSQL(SQl);
			RunInvLogger.getbaseLogger().info("Executed :"+SQl);
			DBbean.close();
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().warn(e);
			RunInvLogger.getbaseLogger().error(e);
		} 
	
		finally
		{
			DBbean.close();
			
		}
		RunInvLogger.getbaseLogger().info("Exit  CartDaoimpl->emptycart");
		
		return y>0?true:false;
		
		
	}

}
