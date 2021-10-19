package dvi.amazingsora.Monopoly.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {
	int lifePoint;
	String name;
	String status;
	int money;
	boolean isTurn;
	int loc;
	JLabel iconLabel;
	
	ImageIcon icon;

	public Player() {

	}

	public Player(int lifePoint, String name, String status, int money, boolean isTurn, int loc) {
		super();
		this.lifePoint = lifePoint;
		this.name = name;
		this.status = status;
		this.money = money;
		this.isTurn = isTurn;
		this.loc = loc;
	}

	public void init() {

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

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public JLabel getIconLabel() {
		return iconLabel;
	}

	public void setIconLabel(JLabel iconLabel) {
		this.iconLabel = iconLabel;
	}

}
