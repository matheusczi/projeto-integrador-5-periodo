package canvas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class CanvasController{
	public static final String CANVAS_SPLASH = "Canvas Splash";
	public static final String CANVAS_MENU = "Canvas Menu";
	public static final String CANVAS_OPTIONS = "Canvas Options";
	public static final String CANVAS_PROGRESS = "Canvas Progress";
	public static final String CANVAS_GAME = "Canvas Game";
	
	private CanvasBase activeCanvas;
	private CanvasSplash canvasSplash;
	private CanvasMenu canvasMenu;
	private CanvasOptions canvasOptions;
	private CanvasProgress canvasProgress;
	private CanvasGame canvasGame;
	
	private Texture buttonTexture1;
	private Texture buttonTexture2;
	private Texture buttonTexture3;
	private Texture buttonTexture4;
	
	public CanvasController(){
		canvasSplash = new CanvasSplash(this);
		canvasMenu = new CanvasMenu(this);
		canvasOptions = new CanvasOptions(this);
		canvasProgress = new CanvasProgress(this);
		canvasGame = new CanvasGame(this);
		activeCanvas = canvasSplash;
	}
	
	public CanvasBase getCanvas(){
		Gdx.input.setInputProcessor(activeCanvas);
		return activeCanvas;
	}
	
	public CanvasGame getCanvasGame(){
		return canvasGame;
	}
	
	public Texture getButtonTexture1(){
		if(buttonTexture1 == null){
			buttonTexture1 = new Texture(Gdx.files.internal("res/image_files/buttons/button1.png"));
		}
		return buttonTexture1;
	}
	
	public Texture getButtonTexture2(){
		if(buttonTexture2 == null){
			buttonTexture2 = new Texture(Gdx.files.internal("res/image_files/buttons/button2.png"));
		}
		return buttonTexture2;
	}
	
	public Texture getButtonTexture3(){
		if(buttonTexture3 == null){
			buttonTexture3 = new Texture(Gdx.files.internal("res/image_files/buttons/bot1.png"));
		}
		return buttonTexture3;
	}
	
	public Texture getButtonTexture4(){
		if(buttonTexture4 == null){
			buttonTexture4 = new Texture(Gdx.files.internal("res/image_files/buttons/bot2.png"));
		}
		return buttonTexture4;
	}
	
	public CanvasBase setCanvasByName(String name){
		if(name == CANVAS_SPLASH){
			activeCanvas = canvasSplash;
		}else if(name == CANVAS_MENU){
			activeCanvas = canvasMenu;
		}else if(name == CANVAS_OPTIONS){
			activeCanvas = canvasOptions;
		}else if(name == CANVAS_PROGRESS){
			activeCanvas = canvasProgress;
		}else if(name == CANVAS_GAME){
			activeCanvas = canvasGame;
			canvasGame.resetData();
		}
		return activeCanvas;
	}
	
	public void dispose(){
		canvasSplash.dispose();
		canvasMenu.dispose();
		canvasOptions.dispose();
		canvasProgress.dispose();
		canvasGame.dispose();
	}
}
