package dvi.amazingsora.Monopoly.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import dvi.amazingsora.Monopoly.controller.GameController;
import dvi.amazingsora.Monopoly.util.FileUtil;

public class DataSaveObject {
	//設置紀錄
	static SettingObject setting = new SettingObject();
	static Map<Integer,Coordinate> coordinateMap;
	static Map<Integer,byte[]> gridPic;
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

	public static Map<Integer, byte[]> getGridPic() {
		return gridPic;
	}

	public static void setGridPic(Map<Integer, byte[]> gridPic) {
		DataSaveObject.gridPic = gridPic;
	}

	public static void setInit() {
		GameController.setButtonController(new HashMap<String, JButton>());
		gridPic = new HashMap<Integer, byte[]>();
		try {
			gridPic.put(1, FileUtil.inputStreamToByte(FileUtil.readFileInputStream("pic/grid1.png")));
			JButton dice = new JButton("按下骰子");

			dice.setBounds(10, 22, 87, 23);
			GameController.getButtonController().put("dice", dice);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataSaveObject.setGridPic(gridPic);

		
		
	}
	
	
	
}
