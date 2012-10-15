package objects;

import java.awt.Rectangle;

import level.Level;

import objects.ObjectBase;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class Character extends ObjectBase{
	public static int DIR_UP = 3;
	public static int DIR_DOWN = 0;
	public static int DIR_RIGHT = 2;
	public static int DIR_LEFT = 1;
	
	protected Texture texture;
	
	protected int direction = DIR_DOWN;
	
	protected int tileRow;
	protected int tileColumn;
	protected int tileWidth;
	protected int tileHeight;

	
	public Character(){
		bounds = new Rectangle(0, 0, Level.cell_width, Level.cell_height);
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(texture, Level.grid_offset_x + bounds.x * Level.cell_width, Main.height - Level.grid_offset_y - bounds.y * Level.cell_height, 0, direction * Level.cell_height, tileWidth, tileHeight);
	}
	
	@Override
	public void update(float deltaTime){

	}
	
	@Override
	public void dispose(){
		if(texture != null){
			texture.dispose();
		}
	}
	
	@Override
	public void keyTyped(char character){
		if(character == 'd'){
			bounds.x++;
			direction = DIR_RIGHT;
		}else if(character == 'a'){
			bounds.x--;
			direction = DIR_LEFT;
		}else if(character == 's'){
			bounds.y++;
			direction = DIR_DOWN;
		}else if(character == 'w'){
			bounds.y--;
			direction = DIR_UP;
		}
	}
	
	public void setSprite(Texture texture){
		this.texture = texture;
	}
	
	public void setTileWidth(int tileWidth){
		this.tileWidth = tileWidth;
	}
	
	public void setTileHeight(int tileHeight){
		this.tileHeight = tileHeight;
	}
	
	public void setTileRows(int tileRow){
		this.tileRow = tileRow;
	}
	
	public void setTileColumns(int tileColumn){
		this.tileColumn = tileColumn;
	}
}
