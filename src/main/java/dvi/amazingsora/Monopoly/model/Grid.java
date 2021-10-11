package dvi.amazingsora.Monopoly.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.collections4.MapUtils;

import dvi.amazingsora.Monopoly.controller.GameController;
import dvi.amazingsora.Monopoly.util.FileUtil;

public class Grid {
	public void init(JPanel panel) throws IOException {
		int loc = 0; //格子
		GameController.setGridMap(new HashMap<String, JTextField>());
		System.out.println("初始化地圖");
		try {
			List<Map<String, String>> coordinatedata = FileUtil
					.getCoordinatedata(FileUtil.readFileInputStream("data/coordinate.txt"));

			for (Map<String, String> data : coordinatedata) {
				JTextField box = new JTextField();
				int width = 57;
				int length = 48;
				if (getCoordinate(data, "X") == 144 && getCoordinate(data, "Y") == 10) {
					width *= 2;
					length *= 2;

				}
				box.setBounds(getCoordinate(data, "X"), getCoordinate(data, "Y"), width, length);
				panel.add(box);
				
				box.setColumns(10);
				GameController.getGridMap().put("loc"+loc, box);
				loc++;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Integer getCoordinate(Map<String, String> data, String key) {
		return Integer.valueOf(MapUtils.getString(data, key));
	}

}
