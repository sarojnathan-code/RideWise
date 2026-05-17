package com.airtribe.ridewise;

import java.time.LocalTime;

public final class Constants {
	
	public final LocalTime CURRENT_TIME = LocalTime.now();

	public static final LocalTime MORNING_PEAK_HOUR_START = LocalTime.of(10, 0); // 10:00 AM
	public static final LocalTime MORNING_PEAK_HOUR_END = LocalTime.of(13, 0);   // 1:00 PM

	public static final LocalTime EVENING_PEAK_HOUR_START = LocalTime.of(19, 0); // 7:00 PM
	public static final LocalTime EVENING_PEAK_HOUR_END = LocalTime.of(21, 0);   // 9:00 PM


}
