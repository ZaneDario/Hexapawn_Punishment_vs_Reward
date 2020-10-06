import java.util.ArrayList;
import java.util.List;

public class Game {

    public static int variants = 0;

     public void start()
     {
         List<Piece> pieces = new ArrayList<Piece>();

         Piece o1 = new Piece('o', 0, 0);
         Piece o2 = new Piece('o', 1, 0);
         Piece o3 = new Piece('o', 2, 0);
         Piece x1 = new Piece('x', 0, 2);
         Piece x2 = new Piece('x', 1, 2);
         Piece x3 = new Piece('x', 2, 2);

         pieces.add(o1);
         pieces.add(o2);
         pieces.add(o3);
         pieces.add(x1);
         pieces.add(x2);
         pieces.add(x3);

         Board initialBoard = new Board(true);
         initialBoard.pieces = pieces;
         initialBoard.posPieces();

         initialBoard.checkVariants();
     }
}
