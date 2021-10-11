package dvi.amazingsora.test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dvi.amazingsora.Monopoly.MenuFrame.MonopolyMenu;
import dvi.amazingsora.Monopoly.model.Grid;
import dvi.amazingsora.Monopoly.model.Player;
import javax.swing.JButton;

public class testWindowDemo extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JFrame frame;
	private JTextField box1;
	private JTextField box2;
	private JTextField box3;
	private JTextField box4;
	private JTextField box5;
	private JTextField box6;
	private JTextField box23;
	private JTextField box21;
	private JTextField box20;
	private JTextField box16;
	private JTextField box26;
	private JTextField box24;
	private JTextField box19;
	private JTextField box17;
	private JTextField box31;
	private JTextField box15;
	private JTextField box14;
	private JTextField box32;
	private JTextField box22;
	private JTextField box25;
	private JTextField box28;
	private JTextField box27;
	private JTextField box30;
	private JTextField box18;
	private JTextField box11;
	private JTextField box10;
	private JTextField box9;
	private JTextField box13;
	private JTextField box8;
	private JTextField box7;
	private JTextField box29;
	private JTextField box33;
	private JButton backbtn;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public testWindowDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 897, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(150, 173, 563, 472);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		try {
			Grid grid = new Grid();

			grid.init(panel);

			backbtn = new JButton("返回");
			backbtn.setBounds(784, 27, 87, 23);
			frame.getContentPane().add(backbtn);
			backbtn.addActionListener(this);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**/

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton) e.getSource();

		if (jb == backbtn) {
			// 隐藏关闭菜单窗口

			this.frame.setVisible(false);
			this.frame.dispose();

			MonopolyMenu game = new MonopolyMenu();
//			game.getFrame().setVisible(true);

		}

	}
}
