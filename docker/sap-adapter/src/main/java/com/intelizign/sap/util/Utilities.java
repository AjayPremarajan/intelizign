package com.intelizign.sap.util;

public class Utilities {

	public static boolean nullCheck(Object... objects) {
		boolean result = true;
		for (int i = 0; i < objects.length ;i++) {
			if(objects[i] == null) {
				result = false;
				throw new RuntimeException("Null check Validation failed");
			}
		}
		return result;
	}
}
