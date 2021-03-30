package com.intelizign.sap.util;

import java.util.UUID;

public class EventIdGenerator {
	public static String generate() {
		return UUID.randomUUID().toString();
	}
}
