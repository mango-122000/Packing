import java.util.ArrayList;

public class Packing {
	
	public static void main (String[] args) {
		ArrayList<Piece> things = new ArrayList<Piece>();
		//System.out.println("hi");
		Box test = new Box(15, 15, 15);
		//System.out.println(test);
		Piece piece1 = new Piece(15, 14, 1,'a');
		Piece piece2 = new Piece(2, 15, 5,'b');
		Piece piece3 = new Piece(16, 16, 10,'c');
		things.add(piece1);
		things.add(piece2);
		things.add(piece3);
		
		for(int counter = 0; counter < things.size(); counter++) {
			for(int inner3 = 0; inner3 < test.getHeight(); inner3 ++) {
			for(int inner1 = 0; inner1 < test.getLength(); inner1 ++) {
				for(int inner2 = 0; inner2 < test.getWidth(); inner2 ++) {
					//for(int inner3 = 0; inner3 < test.getHeight(); inner3 ++) {
					if(test.canAdd(things.get(counter),  inner1, inner2, inner3)){
						test.add(things.get(counter), inner1,  inner2, inner3);
					}
					else {
						things.get(counter).rotate();
						if(test.canAdd(things.get(counter),  inner1, inner2, inner3)){
							test.add(things.get(counter), inner1,  inner2, inner3);
						}
					}
				//}
				}
				}
			}
		}

		System.out.println(test.toString(1));
	}
}
