public class Piece {
	private int length;
	private int width;
	private int height;
	private char symbol;
	
	
	private boolean added;
	
	public Piece (int l, int w, int h, char s) {
		length = l;
		width = w;
		height = h;
		symbol = s;
		added = false;
	}
	
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public char getSymbol() {
		return symbol;
	}
	public boolean isAdded() {
		return added;
	}
	public void setAdd(boolean x) {
		added = x;
	}
	
	public void rotate() {
		int x = length;
		length = width;
		width = x;
	}
	
	
}
