package com.italoschramm.apivotacao.util;

import java.util.Calendar;
import java.util.Date;

public class UtilDate {

	public static Date getCurrentlyDate() {
		Date date = new Date();
		return date;
	}
	
	public static Date getDateAddMinutes(int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentlyDate());
		calendar.add(Calendar.MINUTE, minutes);

		return calendar.getTime(); 
	}
}
