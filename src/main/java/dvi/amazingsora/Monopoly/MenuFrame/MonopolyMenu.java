package dvi.amazingsora.Monopoly.MenuFrame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import dvi.amazingsora.test.testWindowDemo;
import javax.swing.JPanel;

public class MonopolyMenu extends JFrame  {
	/**
	 * 
	 */
	JButton jb1, jb2;

	private static final long serialVersionUID = 1L;

	private JButton startGameButton;
	private JButton settingButton;
	private JPanel panel;
	private JFrame frame;

	CardLayout cardLayout=new CardLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonopolyMenu window = new MonopolyMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MonopolyMenu() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(299, 10, 135, 240);
		frame.getContentPane().add(panel);
		panel.setLayout(cardLayout);
		
		
		settingButton = new JButton("設置");
		settingButton.setBounds(10, 94, 57, 23);
		settingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(panel, "s1");
			}
		});
		
		
		frame.getContentPane().add(settingButton);
//		settingButton.addActionListener(this);
		startGameButton = new JButton("開始遊戲");
		startGameButton.setBounds(10, 10, 81, 23);
		frame.getContentPane().add(startGameButton);
//		startGameButton.addActionListener(this);


	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		JButton jb = (JButton) e.getSource();
//
//		if (jb == startGameButton) {
//			System.out.println("開啟");
//
//			// 隐藏关闭菜单窗口
//			this.setVisible(false);
//			this.dispose();
//			new testWindowDemo().getFrame().setVisible(true);
//		}
//		if (jb == settingButton) {
//
//			cardLayout.show(panel, "s1");
//		}
//	}

}
