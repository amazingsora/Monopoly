package dvi.amazingsora.Monopoly.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dvi.amazingsora.Monopoly.model.DataSaveObject;

public class SettingView extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	JButton saveBtn;
	/**
	 * Create the panel.
	 */
	JFrame frame;

	public SettingView(JFrame frame) {
		frame = new JFrame();
		this.frame = frame;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JLabel playerCount = new JLabel("遊戲人數:");
		playerCount.setBounds(22, 53, 113, 66);
		frame.getContentPane().add(playerCount);

		textField = new JTextField();
		textField.setBounds(81, 76, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(DataSaveObject.getSetting().getPlayerCount()));
		
		saveBtn = new JButton("儲存後返回");
		saveBtn.setBounds(276, 150, 150, 66);
		saveBtn.addActionListener(this);
		
		frame.getContentPane().add(saveBtn);
		frame.setVisible(true);


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton jb = (JButton) e.getSource();

		if (jb == saveBtn) {
			DataSaveObject.getSetting().setPlayerCount(Integer.valueOf(textField.getText()));
			frame.setVisible(false);
			new MonopolyMeum(new JFrame());

		}

	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
