import java.util.ArrayList;
import java.util.List;

public class Board {
    public char[][] board = new char[3][3];
    public List<Piece> pieces = new ArrayList<Piece>();

    public Board()
    {
        for (int i = 0; i < 3; i++) {
            Piece o = new Piece('o', i, 0);
            Piece x = new Piece('x', i, 0);
            board[0][i] = o.type;
            board[1][i] = ' ';
            board[2][i] = x.type;
            pieces.add(o);
            pieces.add(x);
        }

        //Print initial board and pieces.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        init();
    }

    void init()
    {
        //The list of moves which contain more lists of moves should starts here.
    }
}
