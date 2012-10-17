package canvas;

import java.util.ArrayList;

import level.Level;

import objects.ObjectBase;
import objects.Hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CanvasGame extends CanvasBase{
	private ArrayList<ObjectBase> drawables;
	private ArrayList<Music> musics;
	private ArrayList<Sound> audioEffects;
	private Level level = null;
	
	private Hero hero = null;
	
	public CanvasGame(CanvasController controller){
		super(controller);
		drawables = new ArrayList<ObjectBase>();
		musics = new ArrayList<Music>();
		audioEffects = new ArrayList<Sound>();
		
		// texture = new Texture("res/image_files/hero.png");
		
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
		if(level != null){
			level.render(spriteBatch);
		}
		
		for(ObjectBase drawable : drawables){
			drawable.render(spriteBatch);
		}
	}
	
	@Override
	public void update(float deltaTime){
		for(ObjectBase drawable : drawables){
			ObjectBase temporaryDrawable = drawable;
			temporaryDrawable.update(deltaTime);
		}
		level.update(deltaTime);
		if(level.isLevelWon()){
			controller.setCanvasByName(CanvasController.CANVAS_PROGRESS);	
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
}
