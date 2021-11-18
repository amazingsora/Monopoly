package dvi.amazingsora.Monopoly.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dvi.amazingsora.Monopoly.controller.GameController;
import dvi.amazingsora.Monopoly.model.DataSaveObject;
import dvi.amazingsora.Monopoly.model.Grid;
import dvi.amazingsora.Monopoly.model.Player;

public class GameView extends JPanel implements ActionListener, ChangeListener {

	/**
	 * Create the panel.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int W = 300;

	public static final int H = 200;

	JButton jb1, jb2;
	JButton backBtn;
	JFrame frame;
	Timer timer;
	int dicemun = 0;
	JButton dice;

	public GameView(JFrame frame) {
		dice = GameController.getButtonController().get("dice");

		// 設定當前回合
		GameController.setinit();

		frame = new JFrame();
		this.frame = frame;
		frame.setBounds(100, 100, 950, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLayeredPane gameView = new JLayeredPane();
		gameView.setBounds(150, 173, 563, 472);
		frame.getContentPane().add(gameView);
		gameView.setLayout(null);

		this.setLayout(null);
		try {
			Grid grid = new Grid();
			// 方格初始化
			grid.init(gameView);

			JPanel panel = new JPanel();
			panel.setBounds(723, 597, 201, 154);
			frame.getContentPane().add(panel);
			panel.setLayout(null);

			backBtn = new JButton("返回");
			backBtn.setBounds(10, 59, 181, 53);
			backBtn.addActionListener(this);
			panel.add(backBtn);

			JPanel dicePanel = new JPanel();
			dicePanel.setBounds(723, 173, 201, 154);
			frame.getContentPane().add(dicePanel);
			dicePanel.setLayout(null);

			// 遊戲控制器
			GameController.INSTANCE.createPlayers(frame);
			GameController.INSTANCE.setPlayLocIcon(gameView);
//
//			dice = new JButton("按下骰子");
//
//			dice.setBounds(10, 22, 87, 23);
			dicePanel.add(dice);
			// 取得當前玩家

			timer = new Timer(300, this);

			dice.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dice.setEnabled(false);


					// 骰子數
					SecureRandom objSecureRandom = new SecureRandom();
					int random = objSecureRandom.nextInt(6) + 1;
					System.out.println("骰出 " + random + " 點");
					dicemun = random;

					timer.start();

				}
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JButton) {
			if (e.getSource() == backBtn) {
				frame.setVisible(false);
				new MonopolyMeum(new JFrame());

			}
		}

		if (e.getSource() instanceof Timer) {
			if (e.getSource() == timer) {
				if (dicemun == 0) {
					timer.stop();
					GameController.INSTANCE.launchEffect(frame);
					// 下一回合設定
					GameController.INSTANCE.setPlusRound();

				} else {
					GameController.INSTANCE.move();

					dicemun--;
				}

			}
		}


	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	public void stateChanged(ChangeEvent e1) // 实现事件监听器接口中的方法
	{
		System.out.println("擲骰子");

	}
}
