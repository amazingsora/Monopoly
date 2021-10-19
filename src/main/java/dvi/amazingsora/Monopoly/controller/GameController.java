package dvi.amazingsora.Monopoly.controller;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dvi.amazingsora.Monopoly.model.DataSaveObject;
import dvi.amazingsora.Monopoly.model.Player;
import dvi.amazingsora.Monopoly.util.FileUtil;

public class GameController {
	public static GameController INSTANCE = new GameController();
	// 地圖物件
	public static Map<String, JLayeredPane> gridMap;
	// 玩家參數
	public static Map<Integer, Player> playerMap;

	static int nowRound = 0;
	
	int locX[] = {10,10,30,30};
	int locY[] = {10,30,10,30};
	int oriX=0;
	int oriY=0;

	public void createPlayers(JFrame frame) {
		int playCount = DataSaveObject.getSetting().getPlayerCount();
		int loc = 10;
		setPlayerMap(new HashMap<Integer, Player>());

		
		
		for (int i = 0; i < playCount; i++) {
			Player player = new Player(4000, "player" + (i + 1), "LIVE", 4000, false, i);

			try {
				// 取得縮圖
				JLabel box = new JLabel();
				int width = 20;
				int length = 15;
				box.setBounds(locX[i], locY[i], width, length);

				ImageIcon imageIcon = new ImageIcon(
						FileUtil.inputStreamToByte(FileUtil.readFileInputStream("pic/ICON"+i+".png")));
				Image imgi = imageIcon.getImage();
				imgi = imgi.getScaledInstance(20, 15, Image.SCALE_DEFAULT);
				imageIcon.setImage(imgi);
				box.setIcon(imageIcon);
				player.setIconLabel(box);

				player.setIcon(imageIcon);
				getPlayerMap().put(i, player);

			} catch (Exception e) {
				// TODO: handle exception
			}

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
			lifePointField.setText(player.getLifePoint() + "");

			JTextField moneyField = new JTextField();
			moneyField.setBounds(10, 110, 96, 21);
			playerContiner.add(moneyField);
			moneyField.setColumns(10);
			moneyField.setEditable(false);
			moneyField.setText(player.getMoney() + "");

			loc += 228;
		}
		System.out.println("玩家圖案人數= =="+getPlayerMap().size());
	}
/**
 * 擲骰子
 * @param round
 */
	public void throwDice() {
		if(nowRound>=DataSaveObject.getSetting().getPlayerCount()) {
			System.out.println("變更");
			nowRound =nowRound- DataSaveObject.getSetting().getPlayerCount();
			if(nowRound<0) {
				nowRound = 0;
			}
		}
		System.out.println("第 ==="+nowRound+"位");
		Player nowGuy = GameController.getPlayerMap().get(nowRound);
		System.out.println("nowGuy ==="+nowGuy);
		// 骰子數
		SecureRandom objSecureRandom = new SecureRandom();
		int random = objSecureRandom.nextInt(6) + 1;

		System.out.println("結果 ==" + random);
		for (int i = 0; i < random; i++) {
			int length = DataSaveObject.getCoordinateMap().get(nowGuy.getLoc() + (i + 1)).getLength();
			int width = DataSaveObject.getCoordinateMap().get(nowGuy.getLoc() + (i + 1)).getWidth();
			GameController.getPlayerMap().get(nowRound).getIconLabel().setBounds(width+locX[nowRound], length+locY[nowRound], 20, 15);

		}

		nowGuy.setLoc(nowGuy.getLoc() + random);
		nowRound++;
	}
	public void move() {
		if(nowRound>=DataSaveObject.getSetting().getPlayerCount()) {
			System.out.println("變更");
			nowRound =nowRound- DataSaveObject.getSetting().getPlayerCount();
			if(nowRound<0) {
				nowRound = 0;
			}
		}
		System.out.println("第 ==="+nowRound+"位");
		Player nowGuy = GameController.getPlayerMap().get(nowRound);
		// 骰子數

			int length = DataSaveObject.getCoordinateMap().get(nowGuy.getLoc() + 1).getLength();
			int width = DataSaveObject.getCoordinateMap().get(nowGuy.getLoc() + 1).getWidth();
			System.out.println("nowGuy.getLoc() ==="+nowGuy.getLoc());
			GameController.getPlayerMap().get(nowRound).getIconLabel().setBounds(width+locX[nowRound], length+locY[nowRound], 20, 15);

		

		nowGuy.setLoc(nowGuy.getLoc() + 1);
	}

	public void setPlayLocIcon(JLayeredPane gameView) {
		// 設定起始位置
		int playCount = DataSaveObject.getSetting().getPlayerCount();

		for(int i = 0;i<playCount;i++) {
			gameView.add(GameController.getPlayerMap().get(i).getIconLabel(), Integer.valueOf(15));

		}
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

	public static Map<String, JLayeredPane> getGridMap() {
		return gridMap;
	}

	public static void setGridMap(Map<String, JLayeredPane> gridMap) {
		GameController.gridMap = gridMap;
	}

	public static Map<Integer, Player> getPlayerMap() {
		return playerMap;
	}

	public static void setPlayerMap(Map<Integer, Player> playerMap) {
		GameController.playerMap = playerMap;
	}
	public static int getNowRound() {
		
		
		return nowRound;
	}
	public static void setNowRound(int nowRound) {
		GameController.nowRound = nowRound;
	}
	public static void setPlusRound() {
		GameController.nowRound+=1;
	}
	public static void setinit() {
		GameController.nowRound = 0;
	}
	public int[] getLocX() {
		return locX;
	}
	public void setLocX(int[] locX) {
		this.locX = locX;
	}
	public int[] getLocY() {
		return locY;
	}
	public void setLocY(int[] locY) {
		this.locY = locY;
	}
	
}
