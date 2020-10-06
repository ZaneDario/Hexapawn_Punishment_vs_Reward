import java.util.ArrayList;
import java.util.List;

public class Board {

    public boolean xTurn;
    public char[][] board = new char[3][3];
    public List<Piece> pieces = new ArrayList<Piece>();
    public List<Board> possibleVariants = new ArrayList<Board>();

    public Board(boolean xTurn)
    {
        this.xTurn = xTurn;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void posPieces()
    {
        for (Piece piece : pieces ) {
            int xPos = piece.xPos;
            int yPos = piece.yPos;

            board[xPos][yPos] = piece.type;
        }
    }

    public void checkVariants()
    {
        possibleVariants = Variants.getPossibleVariant(this, !this.xTurn);

        for (Board board: possibleVariants) {
            Game.variants++;
            board.checkVariants();
        }

    }
}
