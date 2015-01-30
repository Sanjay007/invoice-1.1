package org.beans;

import java.sql.*;  
import java.util.ArrayList;
//import java.io.*;  

import org.apache.log4j.Logger;
import org.logg.RunInvLogger;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class DBbean {

 private static  String dbURL = "jdbc:mysql://localhost:3308/invoice";
 private static String dbDriver = "com.mysql.jdbc.Driver"; 
 private static String dbUser="root";
 private static String dbPass="root";
 
  //private Connection dbCon;
private static Connection dbCon;

  public DBbean(){  
       super();        
       }

  public static  boolean connect() throws ClassNotFoundException,SQLException{ 
         
	  try {
		  RunInvLogger.getbaseLogger().info("Loading DB  Class  : "+dbDriver);
		  Class.forName(dbDriver);
		  }
	  
	  catch (ClassNotFoundException  e){
		RunInvLogger.getbaseLogger().debug("Class Not Found"+e.getLocalizedMessage().toString());  
		RunInvLogger.getbaseLogger().error(e.getCause());
	  
	  }
         // System.out.print("ccc");
    
          dbCon = DriverManager.getConnection(dbURL,dbUser,dbPass);
          return true; 
        
  
  }

 

  public  static  synchronized void close() { 
        try {
			dbCon.close();
		} catch (SQLException e) {
			
			RunInvLogger.getbaseLogger().debug("Exception thrown \n ERROR:"+e.getMessage());
			RunInvLogger.getbaseLogger().error(e.getCause());
		} 
       
  }

  public static  ResultSet execSQL(String sql) {
	RunInvLogger.getbaseLogger().info("Executing : "+sql);
	  ResultSet r=null;
	  try{
                    Statement s = dbCon.createStatement(); 
                   r = s.executeQuery(sql); 
                    
                    }

catch (SQLException e){
	RunInvLogger.getbaseLogger().debug("Exception thrown \n ERROR:"+e.getMessage());
	RunInvLogger.getbaseLogger().error(e.getCause());
}
return (r == null) ? null : r; 

  }

  public static  int updateSQL(String sql) throws SQLException{  
	  RunInvLogger.getbaseLogger().info("Update SQL Block : "+sql);
                   Statement s = dbCon.createStatement();
                   int r = s.executeUpdate(sql);
                   return (r == 0) ? 0 : r; 
                }
  public static  int[] batchUpdate(ArrayList<String> sql) throws SQLException{  
	  RunInvLogger.getbaseLogger().info("batch Update SQL Block : "+sql.size());
                   Statement s = dbCon.createStatement();
                   dbCon.setAutoCommit(false);
                   for(int i=0;i<sql.size();i++){
                	   System.out.println(sql.get(i));
                	   s.addBatch(sql.get(i).toString());
                   }
                   int[] count = s.executeBatch();
                   
                   dbCon.commit();
                   return count;
  }
                
                 

}

