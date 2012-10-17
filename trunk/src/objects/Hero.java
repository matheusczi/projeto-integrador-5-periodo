package objects;

import java.awt.Rectangle;

import level.Level;

import objects.ObjectBase;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class Hero extends ObjectBase{
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
	
	// reference to parent level -- XXX
	private Level lvl;
	
	public Hero(){
		bounds = new Rectangle(0, 0, Level.cell_width, Level.cell_height);
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(texture, Level.grid_offset_x + bounds.x * Level.cell_width, Main.height - Level.grid_offset_y - (bounds.y+1) * Level.cell_height, 0, direction * Level.cell_height, tileWidth, tileHeight);
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
			move(DIR_RIGHT);
		}else if(character == 'a'){
			move(DIR_LEFT);
		}else if(character == 's'){			
			move(DIR_DOWN);
		}else if(character == 'w'){			
			move(DIR_UP);
		}
	}
	
	private void move(int dir){
		if(dir == DIR_UP){
			direction = DIR_UP;
			if(lvl.moveTo(bounds.x, bounds.y - 1, bounds.x, bounds.y)){
				bounds.y--;
			}
		}else if(dir == DIR_DOWN){
			direction = DIR_DOWN;
			if(lvl.moveTo(bounds.x, bounds.y + 1, bounds.x, bounds.y)){
				bounds.y++;
			}
		}else if(dir == DIR_LEFT){
			direction = DIR_LEFT;
			if(lvl.moveTo(bounds.x - 1, bounds.y, bounds.x, bounds.y)){
				bounds.x--;
			}
		}else if(dir == DIR_RIGHT){
			direction = DIR_RIGHT;
			if(lvl.moveTo(bounds.x + 1, bounds.y, bounds.x, bounds.y)){
				bounds.x++;
			}
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
	
	public void setParentLevel(Level l){
		lvl = l;
	}
}
