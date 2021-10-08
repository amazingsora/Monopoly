package dvi.amazingsora.test;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Uo extends JPanel {

	/**
	 * Create the panel.
	 */
	public Uo() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 208, 153);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(95, 10, 103, 121);
		panel.add(lblNewLabel);
		ImageIcon image = new ImageIcon("E:\\player.png");
		Image img = image.getImage();
		img = img.getScaledInstance(82, 121, Image.SCALE_DEFAULT);
		image.setImage(img);
		
		lblNewLabel.setIcon(image);

	}

}
