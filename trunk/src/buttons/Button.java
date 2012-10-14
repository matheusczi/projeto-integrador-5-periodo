package buttons;

import java.awt.Rectangle;

import objects.ObjectBase;

import buttons.actions.Actionable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class Button extends ObjectBase{
	private Actionable action;
	private Texture background;
	private Texture hover;
	private Texture activeTexture;
	private boolean executeAction;
	private boolean touchHover;
	private BitmapFont font;
	
	public Button(Actionable action, Texture background, Texture hover, Rectangle bounds){
		this.action = action;
		this.background = background;
		this.hover = hover;
		this.activeTexture = background;
		this.bounds = bounds;
		this.executeAction = false;
		this.touchHover = false;
		this.font = new BitmapFont();
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		int y = Main.height - bounds.height - bounds.y;
		spriteBatch.draw(activeTexture, bounds.x, y, bounds.width, bounds.height);
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.draw(spriteBatch, action.getText(), bounds.x + bounds.width + 10, y + bounds.height/2 + 5);
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
