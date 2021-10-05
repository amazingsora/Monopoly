package dvi.amazingsora.Monopoly.MenuFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import dvi.amazingsora.test.testWindowDemo;

public class MonopolyMenu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	JButton jb1, jb2;

	private static final long serialVersionUID = 1L;

	private JButton btnNewButton;

	private JFrame frame;

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
		btnNewButton = new JButton("開始遊戲");
		btnNewButton.setBounds(156, 123, 87, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton) e.getSource();

		if (jb == btnNewButton) {
			// 隐藏关闭菜单窗口

			this.frame.setVisible(false);
			this.frame.dispose();

			 new testWindowDemo().getFrame().setVisible(true);
		}

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	
	
	

}
