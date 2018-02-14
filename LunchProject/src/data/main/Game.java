package data.main;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Game {
	
	static String formattedDate;
	static String t;
	
	public static void startup() {
		LocalDate date = LocalDate.now();
		Date d = new Date((long)(System.currentTimeMillis()));
		formattedDate = new SimpleDateFormat("HH/mm/ss.SSS").format(d);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		t = date.format(formatter);
	}
	
	public static void log(String text) {
		System.out.println("Logged on " + t + " @ " + formattedDate + ": " + text);
	}
	public static void log(float text) {
		System.out.println(textFormat() + text);
	}
	public static String textFormat() {
		return "Logged on " + t + " @ " + formattedDate + ": ";
	}
	
}
