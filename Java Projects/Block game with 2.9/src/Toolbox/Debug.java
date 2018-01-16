package Toolbox;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Debug {
	
	public static void Log(String text) {
		System.out.println(text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void Log(String text, String loggedFrom) {
		System.out.println("[<" + loggedFrom + ">] " + text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void Log(String text, Object clas) {
		System.out.println("[<" + clas.getClass().getName() + ">] " + text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void LogN(String text) {
		System.out.println(text);
	}
	
	public static void Log(int text) {
		System.out.println(text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void Log(int text, String loggedFrom) {
		System.out.println("[<" + loggedFrom + ">] " + text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void Log(int text, Object clas) {
		System.out.println("[<" + clas.getClass().getName() + ">] " + text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void LogN(int text) {
		System.out.println(text);
	}
	
	public static void Log(float text) {
		System.out.println(text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void Log(float text, String loggedFrom) {
		System.out.println("[<" + loggedFrom + ">] " + text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void Log(float text, Object clas) {
		System.out.println("[<" + clas.getClass().getName() + ">] " + text + " : " + "[Logged at: <" + getCurrentLocalDateTimeStamp() + ">]");
	}
	public static void LogN(float text) {
		System.out.println(text);
	}
	
	public static String getCurrentLocalDateTimeStamp() {
	    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
}
