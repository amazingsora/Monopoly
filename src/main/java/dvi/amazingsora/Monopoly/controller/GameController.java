package dvi.amazingsora.Monopoly.controller;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dvi.amazingsora.Monopoly.model.DataSaveObject;
import dvi.amazingsora.Monopoly.model.Player;
import dvi.amazingsora.Monopoly.util.FileUtil;

public class GameController {
	public static GameController INSTANCE = new GameController();

	public static Map<String,JTextField>gridMap ;
	
	
	public void createPlayers(JFrame frame) {
		int playCount = DataSaveObject.getSetting().getPlayerCount();
		int loc = 10;
		DataSaveObject.setTurnsList(playCount);

		for (int i = 0; i < playCount; i++) {
			Player player = new Player(4000,"player"+(i+1),"LIVE",4000);
			DataSaveObject.getTurnsList()[i] = player;

			JPanel playerContiner = new JPanel();
			playerContiner.setBounds(loc, 10, 208, 153);
			frame.getContentPane().add(playerContiner);
			playerContiner.setLayout(null);


			JLabel playerLabel = new JLabel();
			playerLabel.setBounds(120, 15, 90, 110);
			playerContiner.add(playerLabel);

			byte[] imageData = null;
			try {
				imageData = inputStreamToByte(FileUtil.readFileInputStream("pic/player.png"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ImageIcon image = new ImageIcon(imageData);

			playerLabel.setOpaque(true);
			playerLabel.setBackground(Color.white);

			Image img = image.getImage();
			img = img.getScaledInstance(90, 110, Image.SCALE_DEFAULT);
			image.setImage(img);

			playerLabel.setIcon(image);

			JTextField textField_4 = new JTextField();
			textField_4.setBounds(10, 10, 96, 21);
			playerContiner.add(textField_4);
			textField_4.setColumns(10);
			textField_4.setEditable(false);
			textField_4.setText(player.getName());
			

			JTextField lifePointField = new JTextField();
			lifePointField.setBounds(10, 60, 96, 21);
			playerContiner.add(lifePointField);
			lifePointField.setColumns(10);
			lifePointField.setEditable(false);
			lifePointField.setText(player.getLifePoint()+"");


			JTextField moneyField = new JTextField();
			moneyField.setBounds(10, 110, 96, 21);
			playerContiner.add(moneyField);
			moneyField.setColumns(10);
			moneyField.setEditable(false);
			moneyField.setText(player.getMoney()+"");


			loc += 228;
		}
	}

	public static Map<String, JTextField> getGridMap() {
		return gridMap;
	}

	public static void setGridMap(Map<String, JTextField> gridMap) {
		GameController.gridMap = gridMap;
	}

	public static byte[] inputStreamToByte(InputStream is) throws Exception {
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] a = new byte[1000];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = bis.read(a)) != -1) {
			bos.write(a, 0, len);
		}
		bis.close();
		bos.close();
		return bos.toByteArray();
	}
}
