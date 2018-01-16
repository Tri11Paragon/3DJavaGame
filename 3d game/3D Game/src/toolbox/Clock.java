package toolbox;

import org.lwjgl.Sys;

public class Clock {
	
	private boolean paused = false;
	public long lastFrame, totalTime;
	public float d=0, multiplier=1;
	
	public long getTime(){
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
	public float getDelta(){
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		if(delta * 0.001f > 0.05f){
			return 0.05f;
		}
		return delta * 0.001f;
	}
	
	public float Delta(){
		if(paused){
			return 0;
		} else {
			return d * multiplier;
		}
	}
   public float TotalTime(){
	   return totalTime;
   }
   
   public float Multiplier(){
	   return multiplier;
   }
   public void update(){
	   d = getDelta();
	   totalTime += d;
   }
   public void ChangeMultiplier(int change){
	   if(multiplier + change < -1 && multiplier + change > 7){
		   
	   } else {
		   multiplier += change;
	   }
   }
   public void Pause(){
	   if(paused)
		   paused=false;
	   else
		   paused=true;
   }
	
}
