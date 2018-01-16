package Toolbox;

import org.lwjgl.Sys;

public class TimeChecker {
	
	long time1;
	long time2;
	
	public void start() {
		time1 = Sys.getTime() / 1000;
		Debug.Log("Fucked here");
	}
	
	public void stop() {
		time2 = Sys.getTime() / 1000;
		long timeResult = time1 - time2;
		Debug.Log("Time took to do a job: " + timeResult);
	}
	
	public void stop(String clas) {
		time2 = Sys.getTime() / 1000;
		long timeResult = time1 - time2;
		Debug.Log("Time took to do a job: " + timeResult, clas);
	}
	
}
