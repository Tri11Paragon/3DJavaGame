package Data;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
//import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;

import Data.RenderingEngine.MasterRenderer;

public class Main implements Runnable {
	
	private Thread mainThread;
	public boolean isRunning = true;
	
	public long window;
	private GLFWKeyCallback callback;
	
	public static final String name = "BrettCraft";
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	public static void main(String[] args) {
		
		System.out.println("Starting the game");
		Main game = new Main();
		game.start();
		
	}
	
	public void start() {
		isRunning = true;
		mainThread = new Thread(this, name);
		mainThread.start();
	}
	
	// Create display
	public void init() {
		if (glfwInit() != true){
			isRunning = false;
			System.err.println("GLFW INIT FAILED!");
		}
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		
		window = glfwCreateWindow(WIDTH, HEIGHT, name, 0, 0);
		
		if (window == GL_FALSE){
			System.err.println("WTF Your window is broken dude. ");
			isRunning = false;
		}
		glfwSetKeyCallback(window, callback = new Input());
		
		GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, 100, 100);
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		
		MasterRenderer renderer = new MasterRenderer();
		renderer.prepare();
		
	}
	// Update display
	public void update() {
		glfwPollEvents();
		
		if (Input.keys[GLFW_KEY_SPACE]) {
			System.out.println("I GOT YOU");
		}
		
	}
	// Render things / update display
	public void render() {
		glfwSwapBuffers(window);
		
	}
	

	@Override
	public void run() {
		init();
		System.out.println("Game run method started!");
		while(isRunning) {
			update();
			render();
			if (glfwWindowShouldClose(window)){
				isRunning=false;
			}
		}
		callback.free();
	}

}
