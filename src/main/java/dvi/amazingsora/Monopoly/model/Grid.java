package dvi.amazingsora.Monopoly.model;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import org.apache.commons.collections4.MapUtils;

import dvi.amazingsora.Monopoly.controller.GameController;
import dvi.amazingsora.Monopoly.util.FileUtil;

public class Grid {
	public void init(JLayeredPane panel) throws IOException {
		int loc = 0; // 格子
		GameController.setGridMap(new HashMap<String, JLayeredPane>());

		// 地圖座標參數
		DataSaveObject.setCoordinateMap(new HashMap<Integer, Coordinate>());

		System.out.println("初始化地圖");
		try {
			List<Map<String, String>> coordinatedata = FileUtil
					.getCoordinatedata(FileUtil.readFileInputStream("data/coordinate.txt"));

			for (Map<String, String> data : coordinatedata) {

				JLabel box = new JLabel();
				int width = 57;
				int length = 48;
				if (getCoordinate(data, "X") == 144 && getCoordinate(data, "Y") == 10) {
					width *= 2;
					length *= 2;

				}
				Coordinate c = new Coordinate();
				c.setLength(getCoordinate(data, "Y"));
				c.setWidth(getCoordinate(data, "X"));
				DataSaveObject.getCoordinateMap().put(loc, c);
				box.setBounds(getCoordinate(data, "X"), getCoordinate(data, "Y"), width, length);
				panel.add(box, Integer.valueOf(10));

				// 土地圖
				byte[] imageData = null;
				imageData = FileUtil.inputStreamToByte(FileUtil.readFileInputStream("pic/land.png"));
				ImageIcon image = new ImageIcon(imageData);
				Image img = image.getImage();
				img = img.getScaledInstance(width, length, Image.SCALE_DEFAULT);
				image.setImage(img);


				box.setIcon(image);
				GameController.getGridMap().put("loc" + loc, panel);
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
