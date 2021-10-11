package dvi.amazingsora.Monopoly.model;

public class DataSaveObject {
	//設置紀錄
	static SettingObject setting = new SettingObject();
	static Player[] turnsList ;

	public static SettingObject getSetting() {
		return setting;
	}

	public static void setSetting(SettingObject setting) {
		DataSaveObject.setting = setting;
	}

	public static Player[] getTurnsList() {
		return turnsList;
	}

	public static void setTurnsList(int count) {
		DataSaveObject.turnsList = new Player[count];
	}

	
	
	
	
}
