package com.intelizign.sap.util;

public class Utilities {

	public static boolean nullCheck(Object... objects) {
		boolean result = true;
		for (int i = 0; i < objects.length && objects[i] == null; i++) {
			result = false;
			break;
		}
		return result;
	}
}
