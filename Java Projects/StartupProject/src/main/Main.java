package main;

import java.util.Scanner;

public class Main {
	
	public static boolean open = true;
	public static boolean dynamic = false;
	public static Scanner scanner;
	
	public static String filePath = null;
	public static String keyPath = null;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		while (open) {
			detectInput();
		}
	}
	/**
	 * 
	 *  
	 * 
	 */
	public static void detectInput() {
		System.out.println(Encryptor.encrypt("C:/hsvr.txt", "C:/test.txt", true));
		String command = scanner.nextLine();
		command.toLowerCase();
		if (command.contains("exit")) {
			open = false;
			System.exit(0);
		}
		if (command.contains("help")) {
			System.out.println("------------");
			System.out.println("commands: ");
			System.out.println("help - shows command list");
			System.out.println("exit - close the thread");
			System.out.println("activate - start the service");
			System.out.println("set - set the path to the file");
			System.out.println("key - set the path to the key");
			System.out.println("-d or dynamic - enables dynamic encryption");
			System.out.println("------------");
		}
		
		if (command.contains("activate")) {
			if (filePath == null || keyPath == null) {
				System.out.println("------------");
				System.out.println("please enter a key or file path. Use help for more information");
				System.out.println("------------");
				return;
			}
		}
		
		if (command.contains("set")) {
			System.out.println("please enter path: ");
			String path = scanner.nextLine();
			filePath = path;
			System.out.println("------------");
			System.out.println("path change successful");
			System.out.println("path: " + filePath);
			System.out.println("------------");
		}
		
		if (command.contains("key")) {
			System.out.println("please enter key path: ");
			String keyPth = scanner.nextLine();
			keyPath = keyPth;
			System.out.println("------------");
			System.out.println("key path change successful");
			System.out.println("path: " + keyPath);
			System.out.println("------------");
		}
		if (command.contains("-d") ||command.contains("-dynamic")) {
			dynamic = true;
			System.out.println("------------");
			System.out.println("dynamic is now set to true");
			System.out.println("------------");
		}
	}

}
