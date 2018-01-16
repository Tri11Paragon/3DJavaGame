package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Encryptor {
	
	public static String encrypt(String s, String key, boolean useDynamic) {
		char[] chars = null;
		try {
			Stream<String> steam = Files.lines(Paths.get(key));
			chars = steam.toString().toCharArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("------------");
		System.out.println("starting encryption");
		System.out.println("printing char array");
		System.out.println(chars);
		System.out.println("------------");
		for (char c : s.toCharArray()) {
			
		}
		return null;
	}
	
}
