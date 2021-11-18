package dvi.amazingsora.Monopoly.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.apache.commons.lang3.StringUtils;

import dvi.amazingsora.Monopoly.model.DataSaveObject;
import dvi.amazingsora.Monopoly.model.GridObject;
import dvi.amazingsora.Monopoly.model.Player;
import dvi.amazingsora.Monopoly.util.FileUtil;

public class GameController {
	public static GameController INSTANCE = new GameController();
	// 地圖物件
	public static Map<String, JLabel> gridMap;
	// 玩家參數
	public static Map<Integer, Player> playerMap;
	// 地圖數據
	public static Map<Integer, GridObject> gridData;
	// 玩家金錢數據
	public static Map<Integer, JTextField> Assets;
	// 按鈕控制
	public static Map<String, JButton> buttonController;

	// 玩家邊框色
	Color border[] = { Color.MAGENTA, Color.blue, Color.GREEN, Color.ORANGE };
	static int nowRound = 0;

	static int nowLoc = 0;

	int locX[] = { 10, 10, 30, 30 };
	int locY[] = { 10, 30, 10, 30 };
	int oriX = 0;
	int oriY = 0;

	public void createPlayers(JFrame frame) {
		int playCount = DataSaveObject.getSetting().getPlayerCount();
		int loc = 10;
		setPlayerMap(new HashMap<Integer, Player>());
		setAssets(new HashMap<Integer, JTextField>());
		for (int i = 0; i < playCount; i++) {
			Player player = new Player(4000, "player" + (i + 1), "LIVE", 4000, false, 0);
			Border line = BorderFactory.createLineBorder(border[i]);

			try {
				// 取得縮圖
				JLabel box = new JLabel();
				int width = 20;
				int length = 15;
				box.setBounds(locX[i], locY[i], width, length);

				box.setBorder(line);

				ImageIcon imageIcon = new ImageIcon(
						FileUtil.inputStreamToByte(FileUtil.readFileInputStream("pic/ICON" + i + ".png")));
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

			playerLabel.setBorder(line);

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
			getAssets().put(i, moneyField);

			loc += 228;
		}
		System.out.println("玩家圖案人數= ==" + getPlayerMap().size());
	}

	/**
	 * 擲骰子
	 * 
	 * @param round
	 */
	public void throwDice() {
		if (nowRound >= DataSaveObject.getSetting().getPlayerCount()) {
			System.out.println("變更");
			nowRound = nowRound - DataSaveObject.getSetting().getPlayerCount();
			if (nowRound < 0) {
				nowRound = 0;
			}
		}
		System.out.println("第 ===" + nowRound + "位");
		Player nowGuy = GameController.getPlayerMap().get(nowRound);
		System.out.println("nowGuy ===" + nowGuy);
		// 骰子數
		SecureRandom objSecureRandom = new SecureRandom();
		int random = objSecureRandom.nextInt(6) + 1;

		System.out.println("結果 ==" + random);
		for (int i = 0; i < random; i++) {
			int length = DataSaveObject.getCoordinateMap().get(nowGuy.getLoc() + (i + 1)).getLength();
			int width = DataSaveObject.getCoordinateMap().get(nowGuy.getLoc() + (i + 1)).getWidth();
			GameController.getPlayerMap().get(nowRound).getIconLabel().setBounds(width + locX[nowRound],
					length + locY[nowRound], 20, 15);

		}

		nowGuy.setLoc(nowGuy.getLoc() + random);
		nowRound++;
	}

	public void move() {
		if (nowRound >= DataSaveObject.getSetting().getPlayerCount()) {
			nowRound = nowRound - DataSaveObject.getSetting().getPlayerCount();
			if (nowRound < 0) {
				nowRound = 0;
			}
		}
		System.out.println("第 ===" + nowRound + "位");
		Player nowGuy = GameController.getPlayerMap().get(nowRound);
		// 骰子數
		int loc = nowGuy.getLoc() + 1;

		if (loc == (getGridData().size())) {
			loc = 0;
		}
		int length = DataSaveObject.getCoordinateMap().get(loc).getLength();
		int width = DataSaveObject.getCoordinateMap().get(loc).getWidth();
		System.out.println("地圖參數 length===" + length + ", width===" + width);
		System.out.println("nowGuy.getLoc() ===" + nowGuy.getLoc());
		GameController.getPlayerMap().get(nowRound).getIconLabel().setBounds(width + locX[nowRound],
				length + locY[nowRound], 20, 15);

		nowGuy.setLoc(loc);
	}

	public void setPlayLocIcon(JLayeredPane gameView) {
		// 設定起始位置
		int playCount = DataSaveObject.getSetting().getPlayerCount();

		for (int i = 0; i < playCount; i++) {
			gameView.add(GameController.getPlayerMap().get(i).getIconLabel(), Integer.valueOf(15));

		}
	}

	public void launchEffect(JFrame frame) {
		if (nowRound >= DataSaveObject.getSetting().getPlayerCount()) {
			nowRound = nowRound - DataSaveObject.getSetting().getPlayerCount();
			if (nowRound < 0) {
				nowRound = 0;
			}
		}
		Player nowGuy = GameController.getPlayerMap().get(nowRound);

		GameController.setNowLoc(nowGuy.getLoc());

		GridObject grid = GameController.getGridData().get(nowGuy.getLoc());
		String status = grid.getStatus();
		if (StringUtils.equals(status, "M")) {
			int nowMpney = nowGuy.getMoney();
			nowGuy.setMoney(nowMpney + grid.getValue());
			JTextField momeyField = getAssets().get(nowRound);
			momeyField.setText((nowMpney + grid.getValue()) + "");
			System.out.println("第" + nowRound + "位玩家的 金額:" + nowGuy.getMoney());
			String msg = "第" + nowRound + "位玩家的 金額:" + nowGuy.getMoney();
			showMessage(frame, msg, 3000);

		} else if (StringUtils.equals(status, "L")) {

			if (null == grid.getBelong()) {
				setDialog_Land(frame, nowRound, "ddddddd", 0);
			} else if (grid.getBelong() == nowRound) {
				GameController.getButtonController().get("dice").setEnabled(true);

			} else {
				int nowMpney = nowGuy.getMoney();
				System.out.println("現在金額" + grid.getValue());
				nowGuy.setMoney(nowMpney - grid.getValue());
				JTextField momeyField = getAssets().get(nowRound);
				momeyField.setText(nowGuy.getMoney() + "");
				System.out.println("第" + nowRound + "位玩家的 金額:" + nowGuy.getMoney());
				String msg = "第" + nowRound + "位玩家的 金額:" + nowGuy.getMoney();
				showMessage(frame, msg, 3000);
				GameController.getButtonController().get("dice").setEnabled(true);

			}
		}
	}

	private void showMessage(JFrame frame, String msg, int time) {

		JOptionPane op = new JOptionPane(msg);

		op.setComponentOrientation(((frame == null) ? JOptionPane.getRootFrame() : frame).getComponentOrientation());

		JDialog dialog = op.createDialog("");
		dialog.setLocationRelativeTo(frame);

		// 建立一個新計時器
		Timer timer = new Timer();
		// 30秒 後執行該任務
		timer.schedule(new TimerTask() {
			public void run() {
				dialog.setVisible(false);
				dialog.dispose();
			}
		}, time);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.addWindowListener(new WindowListener() {
		

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				GameController.getButtonController().get("dice").setEnabled(true);

			}

			@Override
			public void windowClosed(WindowEvent e) {
				GameController.getButtonController().get("dice").setEnabled(true);
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	

	dialog.setModal(false);
	dialog.setVisible(true);
	GameController.getButtonController().get("dice").setEnabled(true);

	}

	/**
	 * 建立地圖
	 * 
	 * @param frame
	 * @param nowRound
	 * @param msg
	 * @param time
	 */

	private void setDialog_Land(JFrame frame, int nowRound, String msg, int time) {
		JOptionPane op = new JOptionPane(msg);
		JButton jbutton1 = new JButton("Yes");
		JButton jbutton2 = new JButton("NO");
		Player nowGuy = GameController.getPlayerMap().get(nowRound);

		op.setOptions(new Object[] { jbutton1, jbutton2 });

		op.setComponentOrientation(((frame == null) ? JOptionPane.getRootFrame() : frame).getComponentOrientation());

		JDialog dialog = op.createDialog("");
		dialog.setLocationRelativeTo(frame);
		dialog.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				GameController.getButtonController().get("dice").setEnabled(true);
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				GameController.getButtonController().get("dice").setEnabled(true);
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}});
		if (time != 0) {
			// 建立一個新計時器
			Timer timer = new Timer();
			// 30秒 後執行該任務
			timer.schedule(new TimerTask() {
				public void run() {
					dialog.setVisible(false);
					dialog.dispose();
				}
			}, time);
		}

		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		dialog.setModal(false);
		dialog.setVisible(true);
		jbutton1.addActionListener(new ActionListener() {

	@Override
			public void actionPerformed(ActionEvent e) {
				GameController.getButtonController().get("dice").setEnabled(true);

				System.out.println("Yes");
				GridObject grid = GameController.getGridData().get(nowGuy.getLoc());
				grid.setBelong(nowRound);
				grid.setLevel(grid.getLevel() + 1);
				grid.setValue(500 * grid.getLevel());
				// 設定地圖圖片
				int gridLoc = GameController.getNowLoc();
				JLabel box = GameController.getGridMap().get("loc" + gridLoc);

				// 設定邊框
				Border line = BorderFactory.createLineBorder(border[nowRound]);

				// 地磚圖
				ImageIcon image = new ImageIcon(DataSaveObject.getGridPic().get(1));
				Image img = image.getImage();
				img = img.getScaledInstance(box.getWidth(), box.getHeight(), Image.SCALE_DEFAULT);
				image.setImage(img);
				box.setIcon(image);
				box.setBorder(line);

				dialog.dispose();

			}
		});
		jbutton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GameController.getButtonController().get("dice").setEnabled(true);

				System.out.println("NO");
				dialog.dispose();

			}
		});

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

	public static Map<String, JLabel> getGridMap() {
		return gridMap;
	}

	public static void setGridMap(Map<String, JLabel> gridMap) {
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

	public void setNowRound(int nowRound) {
		GameController.nowRound = nowRound;
	}

	public void setPlusRound() {
		GameController.nowRound += 1;
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

	public static Map<Integer, GridObject> getGridData() {
		return gridData;
	}

	public static void setGridData(Map<Integer, GridObject> gridData) {
		GameController.gridData = gridData;
	}

	public static Map<Integer, JTextField> getAssets() {
		return Assets;
	}

	public static void setAssets(Map<Integer, JTextField> assets) {
		Assets = assets;
	}

	public static int getNowLoc() {
		return nowLoc;
	}

	public static void setNowLoc(int nowLoc) {
		GameController.nowLoc = nowLoc;
	}

	public static Map<String, JButton> getButtonController() {
		return buttonController;
	}

	public static void setButtonController(Map<String, JButton> buttonController) {
		GameController.buttonController = buttonController;
	}

}
