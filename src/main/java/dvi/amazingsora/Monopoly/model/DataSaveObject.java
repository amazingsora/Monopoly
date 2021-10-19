package dvi.amazingsora.Monopoly.model;

import java.util.Map;

public class DataSaveObject {
	//設置紀錄
	static SettingObject setting = new SettingObject();
	static Map<Integer,Coordinate> coordinateMap;
	public static SettingObject getSetting() {
		return setting;
	}

	public static void setSetting(SettingObject setting) {
		DataSaveObject.setting = setting;
	}

	
	public static Map<Integer, Coordinate> getCoordinateMap() {
		return coordinateMap;
	}

	public static void setCoordinateMap(Map<Integer, Coordinate> coordinateMap) {
		DataSaveObject.coordinateMap = coordinateMap;
	}

	
	
	
	
}
