package com.i2i;

import java.time.LocalDate;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class main 
{
    private static Logger timeLogger = LogManager.getLogger(main.class);

	public static void main(String[] args) {
		jobStart();
	}

	public static void jobStart() {
		LocalDate date;
		Calendar currentTime;
		date = LocalDate.now();
		currentTime = Calendar.getInstance();
		writeToLogFile(date, currentTime);
	}

	public static void writeToLogFile(LocalDate date, Calendar currentTime) {

		int currentMinute;
		int currentSecond;
		int currentHour ;
		try {
			while (true) {
				currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
				currentMinute = currentTime.get(Calendar.MINUTE);
				currentSecond = currentTime.get(Calendar.SECOND);
				Thread.sleep(1000);
				date = LocalDate.now();
				currentTime = Calendar.getInstance();
				if (currentHour != currentTime.get(Calendar.HOUR_OF_DAY)) {
					timeLogger.warn(getFullTime(currentTime));
				} else if (currentMinute != currentTime.get(Calendar.MINUTE)) {
					timeLogger.error(getFullTime(currentTime));
				} else if (currentSecond != currentTime.get(Calendar.SECOND)) {
					timeLogger.trace(getFullTime(currentTime));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getFullTime(Calendar currentTime) {
		currentTime = Calendar.getInstance();
		return currentTime.get(Calendar.HOUR_OF_DAY) + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND);
	}
}
