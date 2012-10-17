package canvas;

import java.util.ArrayList;

import level.Level;

import objects.ObjectBase;
import objects.Hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class CanvasGame extends CanvasBase{
	private ArrayList<ObjectBase> drawables = null;
	private ArrayList<Music> musics = null;
	private ArrayList<Sound> audioEffects = null;
	private Level level = null;
	
	private Hero hero = null;
	
	private int timer = 0;
	private float timerCount = 0;
	
	private int steps = 0;
	private int moves = 0;
	
	private BitmapFont font;
	
	public CanvasGame(CanvasController controller){
		super(controller);
		drawables = new ArrayList<ObjectBase>();
		musics = new ArrayList<Music>();
		audioEffects = new ArrayList<Sound>();
		
		font = new BitmapFont();
		
		// Music music = Gdx.audio.newMusic(Gdx.files.internal("res/sound_files/Enya - Carribean Blue.mp3"));
		// musics.add(music);
		// music.setLooping(true);
		// music.play();
		
		// Sound sound = Gdx.audio.newSound(Gdx.files.internal("res/sound_files/Instrumentos.wav"));
		// audioEffects.add(sound);
		// sound.play();
	}
	
	public void setLevel(Level level){
		this.level = level;
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.draw(spriteBatch, "Time: " + timer, Main.width - 70, Main.height - 20);
		font.draw(spriteBatch, "Steps: " + steps, Main.width - 80, Main.height - 40);
		font.draw(spriteBatch, "Moves: " + moves, Main.width - 80, Main.height - 60);
		
		if(level != null){
			level.render(spriteBatch);
		}
		
		for(ObjectBase drawable : drawables){
			drawable.render(spriteBatch);
		}
	}
	
	@Override
	public void update(float deltaTime){
		timerCount += deltaTime;
		if(timerCount >= 1.0f){
			timerCount = 0.0f;
			timer++;
		}
		if(level != null){
			level.update(deltaTime);
		}
		
		for(ObjectBase drawable : drawables){
			ObjectBase temporaryDrawable = drawable;
			temporaryDrawable.update(deltaTime);
		}
	}
	
	@Override
	public void dispose(){
		for(ObjectBase drawable : drawables){
			drawable.dispose();
		}
		
		for(Music music : musics){
			if(music != null){
				music.dispose();
			}
		}
		
		for(Sound sound : audioEffects){
			if(sound != null){
				sound.dispose();
			}
		}
	}
	
	@Override
	public boolean keyTyped(char character){
		for(ObjectBase drawable : drawables){
			drawable.keyTyped(character);
		}
		
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
			System.out.println("CanvasGame Enter");
			controller.setCanvasByName(CanvasController.CANVAS_PROGRESS);
		}
		
		return super.keyTyped(character);
	}
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button){
		for(ObjectBase drawable : drawables){
			drawable.touchDown(x, y, pointer, button);
		}
		return super.touchDown(x, y, pointer, button);
	}
	
	@Override
	public boolean touchMoved(int x, int y){
		for(ObjectBase drawable : drawables){
			drawable.touchMove(x, y);
		}
		return super.touchMoved(x, y);
	}
	
	public Hero getHero(){
		if(hero == null){
			hero = new Hero();
			drawables.add(hero);
		}
		return hero;
	}
	
	public void addSteps(){
		steps++;
	}
	
	public void addMoves(){
		moves++;
	}
	
	public void resetData(){
		timer = 0;
		timerCount = 0;
		
		steps = 0;
		moves = 0;
	}
}
