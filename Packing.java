import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Packing {
    public static void main(String[] args) {
        try {
            File file = new File("pieces.txt");
            Scanner scan = new Scanner(file);
            int boxlen = scan.nextInt();
            int boxwid = scan.nextInt();
            int boxhi = scan.nextInt();
            int piecenum = scan.nextInt();
            ArrayList<Piece> things = new ArrayList<Piece>();

            ArrayList<Integer> piecedems = new ArrayList<Integer>();
            ArrayList<Character> piecesyms = new ArrayList<Character>();
            // System.out.println("hi");
            Box test = new Box(boxlen, boxwid, boxhi);
            for (int i = 0; i < piecenum; i++) {
                piecedems.add(scan.nextInt());
                piecedems.add(scan.nextInt());
                piecedems.add(scan.nextInt());
                String saved = scan.next();
                piecesyms.add(saved.charAt(0));
            }
            int layer = scan.nextInt();
            int recorder = 0;
            for (int i = 0; i < piecedems.size(); i += 3) {
                things.add(new Piece(piecedems.get(i), piecedems.get(i + 1), piecedems.get(i + 2),
                        piecesyms.get(recorder)));
                recorder++;
            }
            // System.out.println(test);

            for (int counter = 0; counter < things.size(); counter++) {
                for (int inner3 = 0; inner3 < test.getHeight(); inner3++) {
                    for (int inner1 = 0; inner1 < test.getLength(); inner1++) {
                        for (int inner2 = 0; inner2 < test.getWidth(); inner2++) {
                            // for(int inner3 = 0; inner3 < test.getHeight(); inner3 ++) {
                            if (test.canAdd(things.get(counter), inner1, inner2, inner3)) {
                                test.add(things.get(counter), inner1, inner2, inner3);
                            } else {
                                things.get(counter).rotate();
                                if (test.canAdd(things.get(counter), inner1, inner2, inner3)) {
                                    test.add(things.get(counter), inner1, inner2, inner3);
                                }
                            }
                            // }
                        }
                    }
                }
            }

            System.out.println(test.toString(layer));
        } catch (FileNotFoundException x) {

        }
    }
}
