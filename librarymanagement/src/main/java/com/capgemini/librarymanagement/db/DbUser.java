package com.capgemini.librarymanagement.db;

import java.util.LinkedList;
import java.util.TreeMap;

public class DbUser {
	public static int flag = 100;
	public static int temp;

	@SuppressWarnings("rawtypes")
	public static TreeMap<Integer, LinkedList> bl = new TreeMap<Integer, LinkedList>();

	@SuppressWarnings({ "rawtypes", "unused" })
	public static boolean userDb(LinkedList ll) {

		boolean isSet = false;
		if (ll != null) {
			// mp = new TreeMap<Integer,LinkedList>();
			bl.put(flag, ll);
			LinkedList ty = bl.get(flag);
			temp = flag;

			// System.out.println(ty);
			flag++;
			isSet = true;
		}
		return isSet;
	}// end of userDb()

}
