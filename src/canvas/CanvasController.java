package canvas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
	
	private Texture backGroundTexture1;
	private Texture backGroundTexture2;
	private Texture backGroundTexture3;
	private Texture backGroundTexture4;
	private Texture backGroundTexture6;
	
	private Texture buttonTexture1;
	private Texture buttonTexture2;
	private Texture buttonTexture3;
	private Texture buttonTexture4;
	private Texture buttonTexture5;
	private Texture buttonTexture6;
	private Texture buttonTexture7;
	private Texture buttonTexture8;
	private Texture buttonTexture9;
	private Texture buttonTexture10;
	private Texture buttonTexture11;
	private Texture buttonTexture12;
	private Texture buttonTexture13;
	private Texture buttonTexture14;
	
	private boolean backgroundSoundEnable;
	private boolean effectSoundEnable;
	
	Sound backgroundSound = Gdx.audio.newSound(Gdx.files.internal("res/sound_files/background.wav"));
	Sound moveSound = Gdx.audio.newSound(Gdx.files.internal("res/sound_files/move.wav"));
	Sound moveBoxSound = Gdx.audio.newSound(Gdx.files.internal("res/sound_files/movebox.wav"));
	Sound colideWallSound = Gdx.audio.newSound(Gdx.files.internal("res/sound_files/colidewall.wav"));
	Sound winLevelSound = Gdx.audio.newSound(Gdx.files.internal("res/sound_files/winlevel.wav"));
	private Texture backGroundTexture5;
	
	public CanvasController(){
		canvasSplash = new CanvasSplash(this);
		activeCanvas = canvasSplash;
		canvasMenu = new CanvasMenu(this);
		canvasOptions = new CanvasOptions(this);
		canvasProgress = new CanvasProgress(this);
		canvasGame = new CanvasGame(this);
		
		backgroundSoundEnable = true;
		effectSoundEnable = true;
	}
	
	public CanvasBase getCanvas(){
		Gdx.input.setInputProcessor(activeCanvas);
		return activeCanvas;
	}
	
	public CanvasGame getCanvasGame(){
		return canvasGame;
	}
	
	public Texture getBackGroundTexture1(){
		if(backGroundTexture1 == null){
			backGroundTexture1 = new Texture(Gdx.files.internal("res/image_files/background4.jpg"));
		}
		return backGroundTexture1;
	}
	
	public Texture getBackGroundTexture2(){
		if(backGroundTexture2 == null){
			backGroundTexture2 = new Texture(Gdx.files.internal("res/image_files/background6.jpg"));
		}
		return backGroundTexture2;
	}
	
	public Texture getBackGroundTexture3(){
		if(backGroundTexture3 == null){
			backGroundTexture3 = new Texture(Gdx.files.internal("res/image_files/backgroundMenu.jpg"));
		}
		return backGroundTexture3;
	}
	//eu odeio essa merda de codigo
	public Texture getBackGroundTexture4(){
		if(backGroundTexture4 == null){
			backGroundTexture4 = new Texture(Gdx.files.internal("res/image_files/backgroundProgress.jpg"));
		}
		return backGroundTexture4;
	}
	
	public Texture getBackGroundTexture5(){
		if(backGroundTexture5 == null){
			backGroundTexture5 = new Texture(Gdx.files.internal("res/image_files/backgroundOptions.jpg"));
		}
		return backGroundTexture5;
	}
	
	public Texture getBackGroundTexture6(){
		if(backGroundTexture6 == null){
			backGroundTexture6 = new Texture(Gdx.files.internal("res/image_files/background.jpg"));
		}
		return backGroundTexture6;
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
	
	public Texture getButtonTexture5(){
		if(buttonTexture5 == null){
			buttonTexture5 = new Texture(Gdx.files.internal("res/image_files/buttons/button3.png"));
		}
		return buttonTexture5;
	}
	
	public Texture getButtonTexture6(){
		if(buttonTexture6 == null){
			buttonTexture6 = new Texture(Gdx.files.internal("res/image_files/buttons/button4.png"));
		}
		return buttonTexture6;
	}
	
	public Texture getButtonTexture7(){
		if(buttonTexture7 == null){
			buttonTexture7 = new Texture(Gdx.files.internal("res/image_files/buttons/botao01.png"));
		}
		return buttonTexture7;
	}
	
	public Texture getButtonTexture8(){
		if(buttonTexture8 == null){
			buttonTexture8 = new Texture(Gdx.files.internal("res/image_files/buttons/botao02.png"));
		}
		return buttonTexture8;
	}
	
	public Texture getButtonTexture9(){
		if(buttonTexture9 == null){
			buttonTexture9 = new Texture(Gdx.files.internal("res/image_files/buttons/botao03.png"));
		}
		return buttonTexture9;
	}
	
	public Texture getButtonTexture10(){
		if(buttonTexture10 == null){
			buttonTexture10 = new Texture(Gdx.files.internal("res/image_files/buttons/botao04.png"));
		}
		return buttonTexture10;
	}
	
	public Texture getButtonTexture11(){
		if(buttonTexture11 == null){
			buttonTexture11 = new Texture(Gdx.files.internal("res/image_files/buttons/botao05.png"));
		}
		return buttonTexture11;
	}
	
	public Texture getButtonTexture12(){
		if(buttonTexture12 == null){
			buttonTexture12 = new Texture(Gdx.files.internal("res/image_files/buttons/botao06.png"));
		}
		return buttonTexture12;
	}
	
	public Texture getButtonTexture13(){
		if(buttonTexture13 == null){
			buttonTexture13 = new Texture(Gdx.files.internal("res/image_files/buttons/botao07.png"));
		}
		return buttonTexture13;
	}
	
	public Texture getButtonTexture14(){
		if(buttonTexture14 == null){
			buttonTexture14 = new Texture(Gdx.files.internal("res/image_files/buttons/botao08.png"));
		}
		return buttonTexture14;
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
	
	public CanvasBase setCanvasByName(String name, boolean playWin){
		if(playWin){
			playWinLevel();
			try{
				Thread.sleep(2250);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		return setCanvasByName(name);
	}
	
	public void dispose(){
		canvasSplash.dispose();
		canvasMenu.dispose();
		canvasOptions.dispose();
		canvasProgress.dispose();
		canvasGame.dispose();
		
		backgroundSound.dispose();
		moveSound.dispose();
		moveBoxSound.dispose();
		colideWallSound.dispose();
		winLevelSound.dispose();
	}
	
	public boolean getBackgroundSoundEnable(){
		return backgroundSoundEnable;
	}
	
	public boolean getEffectSoundEnable(){
		return effectSoundEnable;
	}
	
	public void toogleBackgroundSound(){
		backgroundSoundEnable = ! backgroundSoundEnable;
		if(backgroundSoundEnable){
			backgroundSound.loop(0.5f);
		}else{
			backgroundSound.stop();
		}
	}
	
	public void toogleEffectSound(){
		effectSoundEnable = ! effectSoundEnable;
	}
	
	public void toogleSound(){
		toogleBackgroundSound();
		toogleEffectSound();
	}
	
	public void playBackgroundSound(){
		if(backgroundSoundEnable){
			backgroundSound.loop(0.5f);
		}
	}
	
	public void playMove(){
		if(effectSoundEnable){
			moveSound.play();
		}
	}
	
	public void playMoveBox(){
		if(effectSoundEnable){
			moveBoxSound.play();
		}
	}
	
	public void playColideWall(){
		if(effectSoundEnable){
			colideWallSound.play();
		}
	}
	
	public void playWinLevel(){
		if(effectSoundEnable){
			winLevelSound.play();
		}
	}
}
