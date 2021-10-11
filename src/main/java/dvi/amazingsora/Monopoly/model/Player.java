package dvi.amazingsora.Monopoly.model;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
public class Player {
	int lifePoint;
	String name;
	String status;
	int money;
	boolean isTurn;
	
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
