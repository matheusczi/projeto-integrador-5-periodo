package level;

import objects.Hero;
import utils.CommonResources;

import canvas.CanvasController;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class Level{
	private int rows = 0;
	private int columns = 0;
	private String name = "";
	private Cell block = null;
	private Cell target = null;
	private Cell[][] grid = null;
	
	public static int cell_width = 40;
	public static int cell_height = 40;
	
	public static int screen_center_x = 0;
	public static int screen_center_y = 0;
	public static int grid_offset_x = 0;
	public static int grid_offset_y = 0;
	
	private Hero hero = null;
	private CanvasController controller = null;
	
	public Level(CanvasController controller, int rows, int columns, String name){
		this.controller = controller;
		this.rows = rows;
		this.columns = columns;
		this.name = name;
		this.grid = new Cell[columns][rows];
		block = null;
		target = null;
		screen_center_x = Main.width / 2;
		screen_center_y = Main.height / 2;
		grid_offset_x = screen_center_x - (cell_width * columns / 2);
		grid_offset_y = screen_center_y - (cell_height * rows / 2);
	}
	
	public boolean moveTo(int to_x, int to_y, int from_x, int from_y){
		// pode andar na posicao desejada?
		if(grid[to_x][to_y].isWalkable){
			// a posicao desejada tem bloco?
			if(grid[to_x][to_y].hasBlock){
				// a posicao de onde venho tem um bloco?
				if(grid[from_x][from_y].hasBlock){
					return false;
				}else{
					// posso mover bloco no mesmo sentido?
					if(moveTo(to_x + (to_x - from_x), to_y + (to_y - from_y), to_x, to_y)){
						// mover bloco
						grid[to_x][to_y].hasBlock = false;
						grid[to_x + (to_x - from_x)][to_y + (to_y - from_y)].hasBlock = true;
						controller.getCanvasGame().addMoves();
						// pode mover boneco ;)
						return true;
					}else{
						return false;
					}
				}
			}else{
				// posso mover
				controller.getCanvasGame().addSteps();
				return true;
			}
		}
		// nah
		return false;
	}
	
	public void setCharacter(Hero c){
		hero = c;
		hero.setParentLevel(this);
	}
	
	public void setBlock(Cell b){
		block = b;
	}
	
	public void setTarget(Cell t){
		target = t;
	}
	
	public void setCell(int x, int y, Cell c){
		this.grid[x][y] = c;
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getColumns(){
		return columns;
	}
	
	public String getName(){
		return name;
	}
	
	public void render(SpriteBatch spriteBatch){
		CommonResources res = CommonResources.getInstance();
		int dest_x = 0;
		int dest_y = 0;
		for(int i = 0; i < columns; i++){
			for(int j = 0; j < rows; j++){
				// System.out.println("x: "+i*cell_width+" y: "+j*cell_height);
				Cell c = grid[i][j];
				Texture t = res.assets.get(c.tile);
				dest_x = grid_offset_x + (i * (cell_width));
				// inverted y axis minus offset from screen center minus height minus magic number from
				// power of two textures
				// XXX - don`t do this at home
				dest_y = Main.height - grid_offset_y - (j * (cell_height)) - 64;
				spriteBatch.draw(t, dest_x, dest_y);
				if(c.isBlockTarget){
					spriteBatch.draw(res.assets.get(target.tile), dest_x, dest_y);
				}
				if(c.hasBlock){
					spriteBatch.draw(res.assets.get(block.tile), dest_x, dest_y);
				}
			}
		}
		hero.render(spriteBatch);
	}
	
	public void update(float deltaTime){
		hero.update(deltaTime);
	}
}
