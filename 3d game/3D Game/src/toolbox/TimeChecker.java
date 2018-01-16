package toolbox;

import org.lwjgl.Sys;

public class TimeChecker {
	
	long time1;
	long time2;
	
	public void start() {
		time1 = 0;
		time2 = 0;
		time1 = Sys.getTime();
		System.out.println("Starting calculation");
	}
	
	public void stop() {
		time2 = Sys.getTime();
		long timeResult = time1 - time2;
		System.out.println("Time took to do a job: " + timeResult);
		time1 = 0;
		time2 = 0;
	}
	
	public void stop(String clas) {
		time2 = Sys.getTime();
		long timeResult = time1 - time2;
		System.out.println("Time took to do a job: " + timeResult + " : " + clas);
		time1 = 0;
		time2 = 0;
	}
	
}
