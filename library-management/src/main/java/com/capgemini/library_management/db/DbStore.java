package com.capgemini.library_management.db;



import java.util.LinkedList;
import java.util.TreeMap;

public class DbStore {
	public static int flag1 = 1;
	public static int temp1 ;

	public static TreeMap<Integer, LinkedList> mDB =  new TreeMap<Integer,LinkedList>();
	 


	public  static boolean bookDb( LinkedList ll) {
		
		boolean isSet = false;
		if (ll != null) {
			//mDB = new TreeMap<Integer,LinkedList>();
			mDB.put(flag1, ll);
			temp1 = flag1;
			flag1++;
			isSet = true;
			LinkedList ty =  mDB.get(temp1);
			System.out.println(ty);
		}
		return isSet;
	}

}//end of class