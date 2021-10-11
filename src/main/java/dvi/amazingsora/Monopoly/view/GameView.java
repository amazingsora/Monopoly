package dvi.amazingsora.Monopoly.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dvi.amazingsora.Monopoly.controller.GameController;
import dvi.amazingsora.Monopoly.model.DataSaveObject;
import dvi.amazingsora.Monopoly.model.Grid;
import dvi.amazingsora.Monopoly.model.Player;
import javax.swing.JLabel;

public class GameView extends JPanel implements ActionListener {

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

	public GameView(JFrame frame) {
		
		frame = new JFrame();
		this.frame = frame;
		frame.setBounds(100, 100, 950, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel gameView = new JPanel();
		gameView.setBounds(150, 173, 563, 472);
		frame.getContentPane().add(gameView);
		gameView.setLayout(null);
		
		this.setLayout(null);
		try {
			Grid grid = new Grid();

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
			
			JButton dice = new JButton("按下骰子");
			dice.setBounds(10, 22, 87, 23);
			dicePanel.add(dice);
			dice.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SecureRandom objSecureRandom = new SecureRandom();
				      int random = objSecureRandom.nextInt(6);
				      System.out.println("結果 =="+random);
				      GameController.getGridMap().get("loc"+random).setText("loc");
				      
				      
				}
			});
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//遊戲控制器
		GameController.INSTANCE.createPlayers(frame);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();

		if (jb == backBtn) {
			frame.setVisible(false);
			new MonopolyMeum(new JFrame());

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
}
