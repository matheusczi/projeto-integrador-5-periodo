package level;

import utils.CommonResources;

import com.badlogic.gdx.graphics.Texture;

public class Cell {
	public String tile;
	public boolean hasBlock;
	public boolean isBlockTarget;
	public boolean isWalkable;
	public Texture texture;
	
	public Cell(String tile, boolean hasBlock, boolean isBlockTarget, boolean isWalkable){
		this.tile = tile;
		this.texture = CommonResources.getInstance().assets.get(tile);
		this.hasBlock = hasBlock;
		this.isBlockTarget = isBlockTarget;
		this.isWalkable = isWalkable;
		//this.texture = texture;
	}
	
	public Cell(){
		
	}
}
