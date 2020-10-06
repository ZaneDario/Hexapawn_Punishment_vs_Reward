import java.util.ArrayList;
import java.util.List;

public class Board {

    public int depth;
    public boolean xTurn;
    public char[][] board = new char[3][3];
    public List<Piece> pieces = new ArrayList<Piece>();
    public List<Board> possibleVariants = new ArrayList<Board>();
    public boolean isFinished = false;

    public Board(boolean xTurn, int depth)
    {
        this.depth = depth;
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
        drawBoard();
        possibleVariants = Variants.getPossibleVariant(this);

        if(possibleVariants.size() == 0)
        {
            this.isFinished = true;
            Game.countVariants(this.xTurn);
        }

        for (Board board: possibleVariants) {
            if(!board.isFinished)
                board.checkVariants();
        }
    }

    public void drawBoard()
    {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
        System.out.println("------------------------ depth: " + this.depth);
    }
}
