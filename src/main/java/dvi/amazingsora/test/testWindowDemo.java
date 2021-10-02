package dvi.amazingsora.test;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
//	private JTextField textField_3;
//	private JTextField textField_4;
//	private JTextField textField_9;
//	private JTextField textField_17;
//	private JPanel playerContiner_1;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_5;

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

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(259, 104, -97, 109);
		frame.getContentPane().add(desktopPane);

		JPanel panel = new JPanel();
		panel.setBounds(150, 173, 563, 472);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		box1 = new JTextField();
		box1.setBounds(10, 10, 57, 48);
		panel.add(box1);
		box1.setColumns(10);

		box2 = new JTextField();
		box2.setBounds(10, 68, 57, 48);
		panel.add(box2);
		box2.setColumns(10);

		box3 = new JTextField();
		box3.setBounds(10, 126, 57, 48);
		panel.add(box3);
		box3.setColumns(10);

		box4 = new JTextField();
		box4.setBounds(10, 184, 57, 48);
		panel.add(box4);
		box4.setColumns(10);

		box5 = new JTextField();
		box5.setBounds(10, 242, 57, 48);
		panel.add(box5);
		box5.setColumns(10);

		box6 = new JTextField();
		box6.setBounds(10, 298, 57, 48);
		panel.add(box6);
		box6.setColumns(10);

		box7 = new JTextField();
		box7.setBounds(10, 356, 57, 48);
		panel.add(box7);
		box7.setColumns(10);

		box8 = new JTextField();
		box8.setBounds(77, 356, 57, 48);
		panel.add(box8);
		box8.setColumns(10);

		box9 = new JTextField();
		box9.setBounds(144, 356, 57, 48);
		panel.add(box9);
		box9.setColumns(10);

		box10 = new JTextField();
		box10.setBounds(211, 356, 57, 48);
		panel.add(box10);
		box10.setColumns(10);

		box11 = new JTextField();
		box11.setBounds(274, 356, 57, 48);
		panel.add(box11);
		box11.setColumns(10);

		box13 = new JTextField();
		box13.setBounds(341, 356, 57, 48);
		panel.add(box13);
		box13.setColumns(10);

		box14 = new JTextField();
		box14.setBounds(408, 356, 57, 48);
		panel.add(box14);
		box14.setColumns(10);

		box15 = new JTextField();
		box15.setBounds(472, 356, 57, 48);
		panel.add(box15);
		box15.setColumns(10);

		box16 = new JTextField();
		box16.setBounds(472, 298, 57, 48);
		panel.add(box16);
		box16.setColumns(10);

		box17 = new JTextField();
		box17.setBounds(472, 242, 57, 48);
		panel.add(box17);
		box17.setColumns(10);

		box18 = new JTextField();
		box18.setBounds(472, 184, 57, 48);
		panel.add(box18);
		box18.setColumns(10);

		box19 = new JTextField();
		box19.setBounds(472, 126, 57, 48);
		panel.add(box19);
		box19.setColumns(10);

		box20 = new JTextField();
		box20.setBounds(472, 68, 57, 48);
		panel.add(box20);
		box20.setColumns(10);

		box21 = new JTextField();
		box21.setBounds(472, 10, 57, 48);
		panel.add(box21);
		box21.setColumns(10);

		box22 = new JTextField();
		box22.setBounds(408, 10, 57, 48);
		panel.add(box22);
		box22.setColumns(10);

		box23 = new JTextField();
		box23.setBounds(408, 68, 57, 48);
		panel.add(box23);
		box23.setColumns(10);

		box24 = new JTextField();
		box24.setBounds(408, 126, 57, 48);
		panel.add(box24);
		box24.setColumns(10);

		box25 = new JTextField();
		box25.setBounds(408, 184, 57, 48);
		panel.add(box25);
		box25.setColumns(10);

		box26 = new JTextField();
		box26.setBounds(408, 242, 57, 48);
		panel.add(box26);
		box26.setColumns(10);

		box27 = new JTextField();
		box27.setBounds(341, 242, 57, 48);
		panel.add(box27);
		box27.setColumns(10);

		box28 = new JTextField();
		box28.setBounds(341, 126, 57, 48);
		panel.add(box28);
		box28.setColumns(10);

		box29 = new JTextField();
		box29.setColumns(10);
		box29.setBounds(341, 184, 57, 48);
		panel.add(box29);

		box30 = new JTextField();
		box30.setBounds(341, 68, 57, 48);
		panel.add(box30);
		box30.setColumns(10);

		box31 = new JTextField();
		box31.setBounds(274, 68, 57, 48);
		panel.add(box31);
		box31.setColumns(10);

		box32 = new JTextField();
		box32.setBounds(144, 10, 124, 106);
		panel.add(box32);
		box32.setColumns(10);

		box33 = new JTextField();
		box33.setColumns(10);
		box33.setBounds(77, 10, 57, 48);
		panel.add(box33);

		Player player = new Player(4000, "test", "test", 4000);
		player.setFrame(frame);
		player.setMun(2);
		player.init();
		/**/

	}
}
