public class Box {
	private int length;
	private int width;
	private int height;

	private char[][][] layout;
	
	public Box (int l, int w, int h) {
		length = l;
		width = w;
		height = h;

		layout = new char[length][width][height];
		for(int counter = 0; counter < length; counter ++) {
			for (int inner = 0; inner < width; inner ++) {
				for (int inner2 = 0; inner2 < height; inner2 ++) {
				layout[counter][inner][inner2] = '.'; 
				}
			}
		}
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
	
	
	public void add(Piece piece, int row, int col, int depth) {
		piece.setAdd(true);
		for(int inner2 = depth; inner2 < depth + piece.getHeight(); inner2 ++) {
		for(int counter = row; counter < row + piece.getLength(); counter ++) {
			for (int inner = col; inner < col + piece.getWidth(); inner ++) {
				//for(int inner2 = depth; inner2 < depth + piece.getHeight(); inner2 ++) {
				layout[counter][inner][inner2] = piece.getSymbol();
				//}
			}
		}
		}
	}
	
	public boolean canAdd(Piece piece, int row, int col, int depth) {
		if(depth + piece.getHeight() > height || row + piece.getLength() > length || col + piece.getWidth() > width || piece.isAdded() == true) {
			return false;
		}
		for(int inner2 = depth; inner2 < depth + piece.getHeight(); inner2++) {
		for (int counter = row; counter < row + piece.getLength(); counter ++) {
			for(int inner = col; inner < col + piece.getWidth(); inner ++) {
				//for(int inner2 = depth; inner2 < depth + piece.getHeight(); inner2++) {
				if(layout[counter][inner][inner2] != '.') {
					return false;
				}
				//}
			}
		}
		}
		piece.setAdd(true);
		return true;
	}
	
	public String toString(int x) {
		if(x > height || x <= 0) {
			return "Layer not valid";
		}
		String sum = "";
		for (int counter = 0; counter < length; counter ++) {
			for(int inner = 0; inner < width; inner ++) {
				sum = sum + " " + layout[counter][inner][x - 1];
				if(inner == width - 1) {
					sum = sum + "\n";
				}
			}
		}
		return sum;
	}
}
