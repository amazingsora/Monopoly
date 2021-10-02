package dvi.amazingsora.Monopoly.model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Player {
	int lifePoint;
	String name;
	String status;
	int money;
	JFrame frame;
	int mun;
	// 10 228

	public Player() {

	}

	public Player(int lifePoint, String name, String status, int money) {
		super();
		this.lifePoint = lifePoint;
		this.name = name;
		this.status = status;
		this.money = money;


	}

	public void init() {
		if (this.mun < 5 && this.mun > 0) {
			int loc = 10;
			for (int i = 0; i < this.mun; i++) {
				JPanel playerContiner = new JPanel();
				playerContiner.setBounds(loc, 10, 208, 153);
				frame.getContentPane().add(playerContiner);
				playerContiner.setLayout(null);

				JTextField textField_3 = new JTextField();
				textField_3.setBounds(116, 10, 82, 121);
				playerContiner.add(textField_3);
				textField_3.setColumns(10);

				JTextField textField_4 = new JTextField();
				textField_4.setBounds(10, 10, 96, 21);
				playerContiner.add(textField_4);
				textField_4.setColumns(10);

				JTextField textField_9 = new JTextField();
				textField_9.setBounds(10, 60, 96, 21);
				playerContiner.add(textField_9);
				textField_9.setColumns(10);

				JTextField textField_17 = new JTextField();
				textField_17.setBounds(10, 110, 96, 21);
				playerContiner.add(textField_17);
				textField_17.setColumns(10);
				loc += 228;
			}
		}
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getMun() {
		return mun;
	}

	public void setMun(int mun) {
		this.mun = mun;
	}

}
