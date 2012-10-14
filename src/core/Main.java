package core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Main{
	public static int width = 800;
	public static int height = 480;
	
	public static void main(String[] args){
		new LwjglApplication(new Application(), "Pusher", width, height, false);
	}
}