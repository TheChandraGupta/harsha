package com.harsha.app.util;

import java.util.Calendar;
import java.util.Date;

public class ServerTime {
	
	public static long getServerTime() {
		Date now = Calendar.getInstance().getTime();
		long serverTime = now.getTime() / 1000;
		System.out.println("Current Server Time : " + serverTime);
		return serverTime;
	}

}
