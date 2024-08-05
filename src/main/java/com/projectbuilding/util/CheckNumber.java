package com.projectbuilding.util;

public class CheckNumber {
	public static boolean CheckNumber(String s) {
		try {
			Long.parseLong(s);
		} catch(Exception ex) {
			return false;
		}
		return true;
	}
}
