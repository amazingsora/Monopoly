package dvi.amazingsora.Monopoly.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import dvi.amazingsora.Monopoly.model.DataSaveObject;

public class MainWindow {
	int playerCount;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DataSaveObject.setInit();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new MonopolyMeum(frame);
	}

}
