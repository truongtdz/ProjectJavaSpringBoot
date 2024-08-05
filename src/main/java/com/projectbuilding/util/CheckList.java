package com.projectbuilding.util;

import java.util.List;

public class CheckList {
	public static boolean CheckList(List<String> s) {
		if(s == null && s.size() == 0) {
			return false;
		}
		else return true;
	}
}
