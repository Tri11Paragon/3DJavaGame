package Toolbox;

import org.lwjgl.Sys;

public class Debug {
	
	public static void Log(String text) {
		System.out.println(text + " : " + "[Logged at: <" + (Sys.getTime() / 1000) + ">]");
	}
	public static void LogN(String text) {
		System.out.println(text);
	}
	
}
