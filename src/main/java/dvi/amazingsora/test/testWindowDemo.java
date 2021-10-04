package dvi.amazingsora.test;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dvi.amazingsora.Monopoly.model.Grid;
import dvi.amazingsora.Monopoly.model.Player;

public class testWindowDemo {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testWindowDemo window = new testWindowDemo();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player player = new Player(4000, "test", "test", 4000);
		player.setFrame(frame);
		player.setMun(2);
		player.init();
		/**/

	}
}
