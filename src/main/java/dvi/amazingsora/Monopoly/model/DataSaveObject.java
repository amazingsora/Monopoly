package dvi.amazingsora.Monopoly.model;

public class DataSaveObject {
	//設置紀錄
	static SettingObject setting = new SettingObject();

	public static SettingObject getSetting() {
		return setting;
	}

	public static void setSetting(SettingObject setting) {
		DataSaveObject.setting = setting;
	}
	
	
	
	
}
