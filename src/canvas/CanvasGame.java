package canvas;

import java.awt.Rectangle;
import java.util.ArrayList;

import level.Level;
import objects.Hero;
import objects.ObjectBase;
import buttons.Button;
import buttons.actions.GoToMenuSurrending;
import buttons.actions.GoToProgress;
import buttons.actions.levels.GoToLevel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.stbtt.TrueTypeFontFactory;

import core.Main;

public class CanvasGame extends CanvasBase{
	private ArrayList<ObjectBase> drawables = null;
	private Level level = null;
	
	private Hero hero = null;
	
	private int timer = 0;
	private float timerCount = 0;
	
	private int steps = 0;
	private int moves = 0;
	
	private Button retryButton = null;
	
	private BitmapFont font;
	
	public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"�`'<>";
	
	public CanvasGame(CanvasController controller){
		super(controller);
		drawables = new ArrayList<ObjectBase>();
		
		Button b = new Button(new GoToProgress(controller), controller.getButtonTexture14(), controller.getButtonTexture13(), new Rectangle(Main.width - 170, Main.height - 80, 50, 50));
		b.action.setName("Surrender");
		drawables.add(b);
		font = TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("res/font/Capture it.ttf"), FONT_CHARACTERS, 21.0f, 15.0f, 0.5f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


	}
	
	public void setLevel(Level level){
		this.level = level;
		if(retryButton!=null)
			drawables.remove(retryButton);
		retryButton = new Button(new GoToLevel(controller, "Retry", level.getName(), "res/data/levels.json"), controller.getButtonTexture14(), controller.getButtonTexture13(), new Rectangle(Main.width - 170, Main.height - 160, 50, 50));
		drawables.add(retryButton);
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
	}
	
	@Override
	public boolean keyTyped(char character){
		for(ObjectBase drawable : drawables){
			drawable.keyTyped(character);
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
			hero = new Hero(controller);
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
