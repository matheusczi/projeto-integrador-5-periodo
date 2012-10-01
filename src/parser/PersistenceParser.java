package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import persistence.ProgressData;
import persistence.ProgressLevelData;

import json.JSONArray;
import json.JSONException;
import json.JSONObject;
import json.JSONTokener;

public class PersistenceParser {

	public static boolean save(String filename, ProgressData data){
		JSONObject object = new JSONObject();
		JSONObject properties = null;
		ProgressLevelData pd = null;
		Iterator<String> it = data.getKeySet().iterator();

		while(it.hasNext()){
			String s = it.next();
			properties = new JSONObject();
			pd = data.getEntry(s);
			try {
				properties.put("bestTime", pd.bestTime);
				properties.put("bestScore", pd.bestScore);
				properties.put("totalTimePlayed", pd.totalTimePlayed);
				object.put(s, properties);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		FileWriter fw;
		try {
			fw = new FileWriter(filename);
			fw.write(object.toString(4));
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/*
	 * Load persistence from file and return a ProgressData object containing
	 * persistence details
	 */
	public static ProgressData load(String filename){
		JSONTokener tokener = null;
		ProgressData data = null;
		try {
			tokener = new JSONTokener(new FileInputStream(filename));
			JSONObject object = new JSONObject(tokener);
			JSONArray objectKeys = object.names();
			JSONObject jsonLevel = null;

			int length = objectKeys.length();
			// change this settings below to read from configuration file
			data = new ProgressData(length*2, (float) 0.75);

			for(int i = 0; i < length; i++){
				String key = objectKeys.getString(i);
				jsonLevel = object.getJSONObject(key);
				data.addEntry(key, jsonLevel.getInt("bestTime"),
						jsonLevel.getInt("bestScore"),
						jsonLevel.getInt("totalTimePlayed"));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
