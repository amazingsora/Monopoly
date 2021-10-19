package dvi.amazingsora.Monopoly.model;

public class Coordinate {
	Integer Width;
	Integer length;
	public Integer getWidth() {
		return Width;
	}
	public void setWidth(Integer width) {
		Width = width;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Coordinate(Integer width, Integer length) {
		super();
		Width = width;
		this.length = length;
	}
	public Coordinate() {
		super();
	}
	
}
