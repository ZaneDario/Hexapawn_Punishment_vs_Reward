import java.util.ArrayList;
import java.util.List;

public class Variants {

    public static List<Board> getPossibleVariant(Board board) {
        List<Board> possibleVariants = new ArrayList<Board>();

        boolean xTurn = board.xTurn;
        char playing = xTurn ? 'x' : 'o';
        char waiting = xTurn ? 'o' : 'x';
        int ySign = xTurn ? -1 : 1;

        for (Piece piece : board.pieces) {

            int xPos = piece.xPos;
            int yPos = piece.yPos;

            if (piece.type == playing) {

                if (checkBorders(xPos, 0, yPos, ySign) && board.board[xPos][yPos + ySign] == ' ')
                    possibleVariants.add(GenerateVariant(board, playing, waiting, xPos, yPos, 0, ySign));

                if (checkBorders(xPos, -1, yPos, ySign) && board.board[xPos - 1][yPos + ySign] == waiting)
                    possibleVariants.add(GenerateVariant(board, playing, waiting, xPos, yPos, -1, ySign));

                if (checkBorders(xPos, +1, yPos, ySign) && board.board[xPos + 1][yPos + ySign] == waiting)
                    possibleVariants.add(GenerateVariant(board, playing, waiting, xPos, yPos, +1, ySign));
            }
        }

        return possibleVariants;
    }

    private static Board GenerateVariant(Board board, char playing, char waiting, int xPos, int yPos, int xSign, int ySign)
    {
        Board b = new Board(!board.xTurn, board.depth + 1);
        for (Piece p : board.pieces)
        {
            Piece newPiece = new Piece(p.type, p.xPos, p.yPos);

            if (newPiece.xPos == xPos && newPiece.yPos == yPos && newPiece.type == playing)
            {
                newPiece.xPos = xPos + xSign;
                newPiece.yPos = yPos + ySign;

                if((newPiece.type == 'x' && newPiece.yPos == 0) || (newPiece.type == 'o' && newPiece.yPos == 2))
                {
                    b.isFinished = true;
                    Game.countVariantsProm(board.xTurn, newPiece.xPos, newPiece.yPos, playing);
                }

            }

            b.pieces.add(newPiece);

            if (newPiece.xPos == xPos + xSign && newPiece.yPos == yPos + ySign && newPiece.type == waiting) {
                b.pieces.remove(newPiece);
            }
        }
        b.posPieces();

        //if(b.isFinished)
        //    b.drawBoard();

        return b;
    }

    private static boolean checkBorders(int xPos, int xChange, int yPos, int yChange)
    {
        boolean x = (xPos + xChange >= 0 && xPos + xChange < 3);
        boolean y = (yPos + yChange >= 0 && yPos + yChange < 3);
        return (x && y);
    }
}

