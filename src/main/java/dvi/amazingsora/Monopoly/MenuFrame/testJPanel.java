package dvi.amazingsora.Monopoly.MenuFrame;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class testJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public testJPanel() {
		setLayout(null);

		System.out.println("開啟");

//		setLayout(new CardLayout(0, 0));
//		
//		JPanel panel = new JPanel();
//		panel.setSize(450, 150);
//		panel.setVisible(true);
//		add(panel, "name_259382225997500");
//		panel.setLayout(null);
//		
		textField = new JTextField();
		textField.setBounds(94, 149, 96, 21);
		add(textField);
		textField.setColumns(10);

	}

}
