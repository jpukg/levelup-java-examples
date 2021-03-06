package com.levelup.java.date.math;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * This java example will demonstrate adding hours to date.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/add-hours-to-date/'>Add hours to date</a>
 * 
 */
public class DatePlusHours {

	private static final Logger logger = Logger.getLogger(DatePlusHours.class);
	
	@Test
	public void add_hours_to_date_in_java () {
		
		Calendar newYearsEve = Calendar.getInstance();
		newYearsEve.set(2012, 11, 31, 23, 0, 0);
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.setTimeInMillis(newYearsEve.getTimeInMillis());
		newYearsDay.add(Calendar.HOUR, 1);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsEve.getTime()));
		logger.info(dateFormatter.format(newYearsDay.getTime()));

		assertTrue(newYearsDay.after(newYearsEve));
	}

	@Test
	public void add_hours_to_date_in_java_with_joda () {

		DateTime newYearsEve = new DateTime(2012, 12, 31, 23, 0, 0, 0);
		DateTime newYearsDay = newYearsEve.plusHours(1);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(newYearsEve.toString(fmt));
		logger.info(newYearsDay.toString(fmt));

		assertTrue(newYearsDay.isAfter(newYearsEve));
	}

	@Test
	public void add_hours_to_date_in_java_with_apachecommons () {

		Calendar newYearsEve = Calendar.getInstance();
		newYearsEve.set(2012, 11, 31, 23, 0, 0);
		
		Date newYearsDay = DateUtils.addHours(newYearsEve.getTime(), 1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsEve.getTime()));
		logger.info(dateFormatter.format(newYearsDay));

		assertTrue(newYearsDay.after(newYearsEve.getTime()));
	}
	
}
