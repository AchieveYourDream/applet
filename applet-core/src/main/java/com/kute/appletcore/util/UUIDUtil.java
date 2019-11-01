package com.kute.appletcore.util;

import java.util.UUID;

@SuppressWarnings("all")
public class UUIDUtil {

	public static String getUUID() throws Exception {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(getUUID());
//	}

}
