package loaders;

public class MasterSettingsLocationList {
	
	/**
	 *  I know people say not to use global variables, but its this or load a text file everything something happens.
	 *  This way is a quick and easy way to implement settings into a game.
	 */
	public static final boolean useMultithreading = true;
	
	public static float masterBreedingPower = 100.0f;
	public static float redBreedingPower = 100.0f;
	public static float blueBreedingPower = 50.0f;
	public static float greenBreedingPower = 70.0f;
	
	public static float masterSurivalRate = 100.0f;
	public static float redSurivalRate = 10.0f;
	public static float blueSurivalRate = 50.0f;
	public static float greenSurivalRate = 30.0f;
	
	public static int colorChangeChance = 2;
	
	public static int PhysicsFps = 60;
	
	public static void loadSettings() {
		
	}
	
}
