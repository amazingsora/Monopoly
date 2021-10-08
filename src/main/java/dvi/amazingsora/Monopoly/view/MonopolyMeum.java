package dvi.amazingsora.Monopoly.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MonopolyMeum extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MonopolyMeum(JFrame frame) {
		System.out.println("開啟");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JButton startBtn = new JButton("開始");
		startBtn.setBounds(10, 20, 118, 50);
		frame.getContentPane().add(startBtn);
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new GameView(frame);

			}
		});
		JButton settingBtn = new JButton("設定");
		settingBtn.setBounds(10, 134, 118, 50);
		settingBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new SettingView(new JFrame());

			}
		});
		
		
		
		frame.getContentPane().add(settingBtn);
		frame.setVisible(true);

	}

}
