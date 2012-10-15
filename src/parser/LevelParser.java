package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import objects.Character;

import canvas.CanvasController;

import com.badlogic.gdx.graphics.Texture;

import utils.CommonResources;

import json.JSONArray;
import json.JSONException;
import json.JSONObject;
import json.JSONTokener;
import level.Cell;
import level.Level;

public class LevelParser{
	public static Level loadLevel(CanvasController controller, String id, String filename){
		JSONTokener tokener = null;
		Level level = null;
		try{
			if(controller != null && controller.getCanvasGame() != null){
				tokener = new JSONTokener(new FileInputStream(filename));
				JSONObject object = new JSONObject(tokener);
				JSONArray objectKeys = object.names();
				JSONObject jsonLevel = null;
				
				int length = objectKeys.length();
				
				String key = "";
				for(int i = 0; i < length; i++){
					key = objectKeys.getString(i);
					
					if(! key.equals(id))
						continue;
					
					jsonLevel = object.getJSONObject(key);
					
					// assets stuff
					JSONObject assets = jsonLevel.getJSONObject("tiles");
					JSONArray assets_keys = assets.names();
					CommonResources cr = CommonResources.getInstance();
					
					if(assets_keys != null){
						for(int k = 0; k < assets_keys.length(); k++){
							cr.assets.put(assets_keys.getString(k), new Texture(assets.getString(assets_keys.getString(k))));
						}
					}
					
					// grid and map stuff
					JSONObject grid = jsonLevel.getJSONObject("grid");
					int rows = grid.getInt("rows");
					int columns = grid.getInt("columns");
					level = new Level(rows, columns, key);
					Cell block = null;
					block = new Cell(grid.getString("block"), true, false, false);
					level.setBlock(block);
					Cell target = null;
					target = new Cell(grid.getString("target"), false, false, false);
					level.setTarget(target);
					JSONArray map = grid.getJSONArray("map");
					JSONObject jcell = null;
					Cell cell = null;
					for(int j = 0; j < map.length(); j++){
						jcell = map.getJSONObject(j);
						cell = new Cell(jcell.getString("tile"), jcell.getBoolean("hasBlock"), jcell.getBoolean("isBlockTarget"), jcell.getBoolean("walkable"));
						// System.out.println("x: "+j%rows+" y: "+(int)Math.floor(j/rows));
						level.setCell(j % rows, (int)Math.floor(j / rows), cell);
					}
					JSONObject characterJson = jsonLevel.getJSONObject("character");
					cr.assets.put("character", new Texture(characterJson.getString("sprite")));
					int tile_width = characterJson.getInt("tile-width");
					int tile_height = characterJson.getInt("tile-height");
					int tile_rows = characterJson.getInt("rows");
					int tile_columns = characterJson.getInt("columns");
					// TODO: find a way of setting keyframes from json
					// String[] keyframes = characterJson.getJSONArray("keyframes").toString().split(",");
					
					Character character = controller.getCanvasGame().getHero();
					character.setSprite(cr.assets.get("character"));
					character.setTileWidth(tile_width);
					character.setTileHeight(tile_height);
					character.setTileRows(tile_rows);
					character.setTileColumns(tile_columns);
					JSONObject startPosition = characterJson.getJSONObject("startPosition");
					character.setX(startPosition.getInt("x"));
					character.setY(startPosition.getInt("y"));
					level.setCharacter(character);
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		return level;
	}
}
