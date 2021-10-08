package dvi.amazingsora.Monopoly.model;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dvi.amazingsora.Monopoly.util.FileUtil;
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

//				JTextField textField_3 = new JTextField();
//				textField_3.setBounds(116, 10, 82, 121);
//				playerContiner.add(textField_3);
//				textField_3.setColumns(10);
//				textField_3.setEditable(false);
				
				JLabel player = new JLabel();
				player.setBounds(120, 15, 90, 110);
				playerContiner.add(player);
				
				byte[] imageData = null;
				try {
					imageData = inputStreamToByte(FileUtil.readFileInputStream("pic/player.png"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ImageIcon image = new ImageIcon(imageData);

				player.setOpaque(true);
				player.setBackground(Color.white);
				
				Image img = image.getImage();
				img = img.getScaledInstance(90, 110, Image.SCALE_DEFAULT);
				image.setImage(img);
				
				player.setIcon(image);
				
				
				JTextField textField_4 = new JTextField();
				textField_4.setBounds(10, 10, 96, 21);
				playerContiner.add(textField_4);
				textField_4.setColumns(10);
				textField_4.setEditable(false);

				JTextField textField_9 = new JTextField();
				textField_9.setBounds(10, 60, 96, 21);
				playerContiner.add(textField_9);
				textField_9.setColumns(10);
				textField_9.setEditable(false);

				JTextField textField_17 = new JTextField();
				textField_17.setBounds(10, 110, 96, 21);
				playerContiner.add(textField_17);
				textField_17.setColumns(10);
				textField_17.setEditable(false);

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
	
	 public static byte[] inputStreamToByte(InputStream is) throws Exception{
	        BufferedInputStream bis = new BufferedInputStream(is);
	        byte [] a = new byte[1000];
	        int len = 0;
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        while((len = bis.read(a))!=-1){
	            bos.write(a, 0, len);
	        }
	        bis.close();
	        bos.close();
	        return bos.toByteArray();
	    }

}
