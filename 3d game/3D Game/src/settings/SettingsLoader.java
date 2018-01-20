package settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SettingsLoader {
	
	public static String settings = "";
	public static String filePath = "res/settings/settings.settings";
	
	public static int MSAA = 0;
	public static int DEPTHBUFFERBITS = 0;
	public static boolean ENABLEAA = false;
	public static boolean ENABLEASF = false;
	public static float ASF = 0;
	public static boolean USEMIPMAP = false;
	
	public static void loadSettingsFile() {
		FileReader fr = null;
		try {
			fr = new FileReader(new File(filePath));
			BufferedReader reader = new BufferedReader(fr);
			String line;
			while (true) {
				line = reader.readLine();
				String[] currentLine = line.split(" ");
				if (line.startsWith("# ")) {
					//System.out.println(line);
				} else {
					if (line.startsWith("s ") && line.contains("MSAA")) {MSAA = Integer.parseInt(currentLine[2]);}
					if (line.startsWith("s ") && line.contains("BUFFERBITS")) {DEPTHBUFFERBITS = Integer.parseInt(currentLine[2]);}
					if (line.startsWith("s ") && line.contains("ENABLEAA")) {ENABLEAA = Boolean.parseBoolean(currentLine[2]);}
					if (line.startsWith("s ") && line.contains("ENABLEASF")) {ENABLEASF = Boolean.parseBoolean(currentLine[2]);}
					if (line.startsWith("s ") && line.contains("ASFLEVEL")) {ASF = Float.parseFloat(currentLine[2]);}
					if (line.startsWith("s ") && line.contains("USEMIPMAP")) {USEMIPMAP = Boolean.parseBoolean(currentLine[2]);}
				}
				if (line.contains("end;")) {
					break;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean loadSettingBool(String path) {
		return false;
	}
	
}
