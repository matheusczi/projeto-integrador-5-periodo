package utils;

import java.util.LinkedHashMap;

import com.badlogic.gdx.graphics.Texture;

public class CommonResources {
	public LinkedHashMap<String, Texture> assets = null;
	private static CommonResources _instance = null;
	
	private CommonResources(){
		assets = new LinkedHashMap<String, Texture>(40);
	}
	
	public static CommonResources getInstance(){
		if(_instance != null){
			return _instance;
		}
		_instance = new CommonResources();
		return _instance;
	}
}
