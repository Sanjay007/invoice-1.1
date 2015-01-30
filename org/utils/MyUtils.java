package org.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.logg.RunInvLogger;

public class MyUtils {

	
	public static String getformated(String date) throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
		Date dat = formatter.parse(date);
		//System.out.println(date);
		System.out.println(formatter.format(dat));
		return(formatter.format(dat));
	}

	public static String getTodaysdate(){
		SimpleDateFormat sf=new SimpleDateFormat("dd:MM:YYYY hh:mm:ss");
		Date d=new Date();
		return sf.format(d).toString();
		
	}
	
	public static int  genInvId(){
		Random r=new Random();
		int invid=r.nextInt(100000);
		RunInvLogger.getbaseLogger().info("Generated Invoice ID :"+invid);
		return invid;
	}

public static int convtoInt(String S){
	return Integer.parseInt(S);
	
	
}

public static double convtoDouble(String S){
	return Double.parseDouble(S);	
	
}




}


