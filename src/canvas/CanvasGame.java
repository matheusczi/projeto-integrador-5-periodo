package canvas;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import character.CharacterBase;

public class CanvasGame extends CanvasBase{
	private ArrayList<CharacterBase> drawables;
	private ArrayList<Music> musics;
	private ArrayList<Sound> audioEffects;
	
	Texture texture;
	
	public CanvasGame(CanvasController controller){
		super(controller);
		drawables = new ArrayList<CharacterBase>();
		musics = new ArrayList<Music>();
		audioEffects = new ArrayList<Sound>();
		
		texture = new Texture(Gdx.files.internal("res/image_files/hero.png"));
		
		Music music = Gdx.audio.newMusic(Gdx.files.internal("res/sound_files/Enya - Carribean Blue.mp3"));
		musics.add(music);
		music.setLooping(true);
		music.play();
		
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("res/sound_files/Instrumentos.wav"));
		audioEffects.add(sound);
		sound.play();
	}
	
	@Override
	public void render(SpriteBatch spriteBatch) {
		spriteBatch.draw(texture, 10, 10);
		
		for(CharacterBase drawable : drawables){
			drawable.render(spriteBatch);
		}
	}
	
	@Override
	public void update(float deltaTime) {
		for(CharacterBase drawable : drawables){
			drawable.update(deltaTime);
		}
	}
	
	@Override
	public void dispose() {
		if(texture != null){
			texture.dispose();
		}
		
		for(CharacterBase drawable : drawables){
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
	public boolean keyTyped(char character) {
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
			System.out.println("CanvasGame Enter");
			controller.setCanvasByName(CanvasController.CANVAS_PROGRESS);
		}
		return super.keyTyped(character);
	}
}
