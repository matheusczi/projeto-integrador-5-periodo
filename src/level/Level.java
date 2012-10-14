package level;

import utils.CommonResources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class Level {
	private int rows;
	private int columns;
	private String name;
	private Cell block;
	private Cell target;
	private int playerStartX;
	private int playerStartY;
	private Cell[][] grid;
	
	private int cell_width = 40;
	private int cell_height = 40;
	
	private int screen_center_x = Main.width / 2;
	private int screen_center_y = Main.height / 2;
	private int grid_offset_x = 0;
	private int grid_offset_y = 0;
	
	public Level(int rows, int columns, String name){
		this.rows = rows;
		this.columns = columns;
		this.name = name;
		this.grid = new Cell[rows][columns];
		block = null;
		target = null;
		playerStartX = 0;
		playerStartY = 0;
		screen_center_x = Main.width / 2;
		screen_center_y = Main.height / 2;
		grid_offset_x = screen_center_x-(cell_width*columns/2);
		grid_offset_y = screen_center_y-(cell_height*rows/2);
	}

	public void setBlock(Cell b){
		block = b;
	}
	
	public void setTarget(Cell t){
		target = t;
	}
	
	public void setStartPosition(int x, int y){
		playerStartX = x;
		playerStartY = y;
	}
	
	public void setCell(int x, int y, Cell c){
		this.grid[x][y] = c;
	}
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public String getName() {
		return name;
	}

	public void draw(SpriteBatch spriteBatch){
		CommonResources res = CommonResources.getInstance();
		int dest_x = 0;
		int dest_y = 0;
		for(int i=0; i < rows; i++){
			for(int j=0; j< columns; j++){
//				System.out.println("x: "+i*cell_width+" y: "+j*cell_height);
				Cell c = grid[i][j];
				Texture t = res.assets.get(c.tile);
				dest_x = grid_offset_x + (i * (cell_width));
				dest_y = grid_offset_y + (j * (cell_height));
				spriteBatch.draw(t, dest_x, dest_y);
				if(c.isBlockTarget){
					spriteBatch.draw(res.assets.get(target.tile), dest_x, dest_y);
				}
				if(c.hasBlock){
					spriteBatch.draw(res.assets.get(block.tile), dest_x, dest_y);
				}
			}
		}
	}
	
}
