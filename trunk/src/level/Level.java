package level;

import objects.Hero;
import utils.CommonResources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import core.Main;

public class Level {
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
	
	public int steps = 0;
	public int boxSteps = 0;
	// minimo necessario para completar a fase
	private int minSteps = 0;
	private int minBoxSteps = 0;
	
	// score máximo atingivel no level, configurado pelo json, para
	// calculo de pontuacao
	private int topScore = 0;
	
	// score maximo ja atingido na fase, salvo pela persistencia,
	// ainda nao sei se vou precisar disso aqui ou nao, mas acho que nao
	public int maxScore = 0;
	
	// meu score feliz ;)
	public int score = 0;
	
	private Hero hero = null;
	
	public Level(int rows, int columns, String name){
		this.rows = rows;
		this.columns = columns;
		this.name = name;
		this.grid = new Cell[rows][columns];
		block = null;
		target = null;
		screen_center_x = Main.width / 2;
		screen_center_y = Main.height / 2;
		grid_offset_x = screen_center_x-(cell_width*columns/2);
		grid_offset_y = screen_center_y-(cell_height*rows/2);
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
					if(moveTo(to_x+(to_x-from_x),to_y+(to_y-from_y),to_x, to_y)){
						// mover bloco
						grid[to_x][to_y].hasBlock = false;
						grid[to_x+(to_x-from_x)][to_y+(to_y-from_y)].hasBlock = true;
						boxSteps++;
						System.out.println("Steps: "+steps+" boxSteps: "+boxSteps);
						// pode mover boneco ;)
						return true;
					}else{
						return false;
					}
				}
			}else{
				// posso mover
				steps++;
				System.out.println("Steps: "+steps+" boxSteps: "+boxSteps);
				return true;
			}
		}
		// nah
		return false;
	}

	public void setMinSteps(int s){
		minSteps = s;
	}
	
	public void setMinBoxSteps(int s){
		minBoxSteps = s;
	}
	
	public void setTopScore(int s){
		topScore = s;
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
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public String getName() {
		return name;
	}

	public boolean isLevelWon(){
		for(int i=0; i < rows; i++){
			for(int j=0; j < columns; j++){
				if(grid[i][j].isBlockTarget && !grid[i][j].hasBlock){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void render(SpriteBatch spriteBatch){
		CommonResources res = CommonResources.getInstance();
		int dest_x = 0;
		int dest_y = 0;
		for(int i=0; i < rows; i++){
			for(int j=0; j< columns; j++){
//				System.out.println("x: "+i*cell_width+" y: "+j*cell_height);
				Cell c = grid[i][j];
				Texture t = res.assets.get(c.tile);
				dest_x = grid_offset_x + (i * (cell_width));
				// inverted y axis minus offset from screen center minus height minus magic number from
				// power of two textures 
				// XXX - don`t do this at home
				dest_y = Main.height-grid_offset_y - (j * (cell_height)) - 64;
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
		score = topScore - steps*5 - boxSteps*10;
		hero.update(deltaTime);
	}
}
