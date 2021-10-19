package dvi.amazingsora.Monopoly.MenuFrame;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
		startGameButton = new JButton("開始遊戲");
		startGameButton.setBounds(10, 10, 81, 23);
		frame.getContentPane().add(startGameButton);


	}


}
