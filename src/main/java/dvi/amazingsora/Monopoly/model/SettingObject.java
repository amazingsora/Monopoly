package dvi.amazingsora.Monopoly.model;

public class SettingObject {
	int playerCount;

	public SettingObject() {
		this.playerCount = 2;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		if(playerCount>4||playerCount<3) {
			playerCount =2;
		}
		this.playerCount = playerCount;
	}
	
	
}
