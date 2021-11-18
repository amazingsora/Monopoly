package dvi.amazingsora.test.T1;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.*;

public class JDialogTest extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel about = new JLabel("关于:这可是JAVA写的连连看哦！");

	public JDialogTest() {
		this.setTitle("About");
		this.setSize(320, 200);
		this.setVisible(true);

		this.getContentPane().add(about, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		new JDialogTest();
	}

}