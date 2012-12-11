package buttons;

import java.awt.Rectangle;

import objects.ObjectBase;

import buttons.actions.Actionable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.stbtt.TrueTypeFontFactory;

import core.Main;

public class Button extends ObjectBase{
	private Actionable action;
	private Texture background;
	private Texture hover;
	private Texture activeTexture;
	private boolean executeAction;
	private boolean touchHover;
	BitmapFont font;
	public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	
	public Button(Actionable action, Texture background, Texture hover, Rectangle bounds){
		this.action = action;
		this.background = background;
		this.hover = hover;
		this.activeTexture = background;
		this.bounds = bounds;
		this.executeAction = false;
		this.touchHover = false;
		font = TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("res/font/Capture it.ttf"), FONT_CHARACTERS, 21.0f, 15.0f, 0.5f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		font = TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("res/font/Base 02.ttf"), FONT_CHARACTERS, 38.5f, 28.0f, 1.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		int y = Main.height - bounds.height - bounds.y;
		spriteBatch.draw(activeTexture, bounds.x, y, bounds.width, bounds.height);
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.draw(spriteBatch, action.getText(), bounds.x + bounds.width + 10, y + bounds.height/2 - 7);
	}
	
	@Override
	public void update(float deltaTime){
		if(touchHover){
			activeTexture = hover;
		}else{
			activeTexture = background;
		}
		
		if(executeAction){
			executeAction = false;
			action.action();
		}
	}
	
	@Override
	public void touchDown(int x, int y, int pointer, int button){
		if(bounds.contains(x, y)){
			executeAction = true;
		}
		super.touchDown(x, y, pointer, button);
	}
	
	@Override
	public void touchMove(int x, int y){
		if(bounds.contains(x, y)){
			touchHover = true;
		}else{
			touchHover = false;
		}
		super.touchMove(x, y);
	}
	
	@Override
	public void dispose(){
		super.dispose();
		if(background != null){
			background.dispose();
		}
		if(hover != null){
			hover.dispose();
		}
	}
}
