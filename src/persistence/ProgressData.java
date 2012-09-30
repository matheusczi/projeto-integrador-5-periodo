package persistence;

import java.util.LinkedHashMap;

public class ProgressData {
	private LinkedHashMap<String, ProgressLevelData> data;
	
	public ProgressData(int initialCapacity, float loadFactor){
		data = new LinkedHashMap<String, ProgressLevelData>(initialCapacity, loadFactor);
	}
	
	public void addEntry(String id, int bestTime, int bestScore, int totalTimePlayed){
		ProgressLevelData d = new ProgressLevelData();
		d.bestTime = bestTime;
		d.bestScore = bestScore;
		d.totalTimePlayed = totalTimePlayed;
		
		data.put(id, d);
	}
	
	public void changeEntry(String id, int bestTime, int bestScore, int totalTimePlayed){
		ProgressLevelData d = data.get(id);
		d.bestTime = bestTime;
		d.bestScore = bestScore;
		d.totalTimePlayed = totalTimePlayed;
		
		data.put(id, d);
	}
	
	public ProgressLevelData getEntry(String id){
		return data.get(id);
	}
	
	public ProgressLevelData removeEntry(String id){
		return data.remove(id);
	}
}