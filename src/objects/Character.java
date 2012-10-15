package objects;

import java.awt.Rectangle;

import level.Level;

import objects.ObjectBase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class Character extends ObjectBase{
	public static int DIR_UP = 3;
	public static int DIR_DOWN = 0;
	public static int DIR_RIGHT = 2;
	public static int DIR_LEFT = 1;
	
	private static boolean KEY_LEFT = false;
	private static boolean KEY_RIGHT = false;
	private static boolean KEY_UP = false;
	private static boolean KEY_DOWN = false;
	
	protected Texture texture;
	
	protected int speedX;
	protected int speedY;
	protected int tile_row;
	protected int tile_column;
	protected int tile_width;
	protected int tile_height;
	
	protected int direction;
	
	protected int x;
	protected int y;
	
	public Character(){
		bounds = new Rectangle();
		
		direction = DIR_DOWN;
		
		speedX = 100;
		speedY = 100;
	}
	
	@Override
	public void render(SpriteBatch spriteBatch){
		spriteBatch.draw(texture, Level.grid_offset_x+x*Level.cell_width, Main.height-Level.grid_offset_y-y*Level.cell_height, 0, direction*tile_height, tile_width, tile_height);
	}
	
	@Override
	public void update(float deltaTime){
		if(Gdx.input.getInputProcessor().keyUp(Keys.DPAD_LEFT)){
			KEY_LEFT = false;
		}
		if(Gdx.input.getInputProcessor().keyUp(Keys.DPAD_RIGHT)){
			KEY_RIGHT = false;
		}
		if(Gdx.input.getInputProcessor().keyUp(Keys.DPAD_UP)){
			KEY_UP = false;
		}
		if(Gdx.input.getInputProcessor().keyUp(Keys.DPAD_DOWN)){
			KEY_DOWN = false;
		}
		if(KEY_DOWN || KEY_UP || KEY_LEFT || KEY_RIGHT)
			return;
		if(Gdx.input.getInputProcessor().keyDown(Keys.DPAD_LEFT) && !KEY_LEFT){
//			bounds.x -= deltaTime * speedX;
			direction = DIR_LEFT;
			KEY_LEFT = true;
			x--;
		}
		if(Gdx.input.getInputProcessor().keyDown(Keys.DPAD_RIGHT) && !KEY_RIGHT){
//			bounds.x += deltaTime * speedX;
			direction = DIR_RIGHT;
			KEY_RIGHT = true;
//			x++;
		}
		if(Gdx.input.getInputProcessor().keyDown(Keys.DPAD_UP) && !KEY_UP){
//			bounds.y += deltaTime * speedY;
			direction = DIR_UP;
			KEY_UP = true;
//			y--;
		}
		if(Gdx.input.getInputProcessor().keyDown(Keys.DPAD_DOWN) && !KEY_DOWN){
//			bounds.y -= deltaTime * speedY;
			direction = DIR_DOWN;
			KEY_DOWN = true;
//			y++;
		}
	}
	
	@Override
	public void dispose(){
		if(texture != null){
			texture.dispose();
		}
	}

	public void setSprite(Texture tex) {
		// TODO Auto-generated method stub
		texture = tex;
	}

	public void setTileWidth(int tile_width) {
		// TODO Auto-generated method stub
		this.tile_width = tile_width;
	}

	public void setTileHeight(int tile_height) {
		// TODO Auto-generated method stub
		this.tile_height = tile_height;
	}

	public void setTileRows(int tile_rows) {
		// TODO Auto-generated method stub
		this.tile_row = tile_rows;
	}

	public void setTileColumns(int tile_columns) {
		// TODO Auto-generated method stub
		this.tile_column = tile_columns;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
}
