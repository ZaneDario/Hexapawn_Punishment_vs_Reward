import java.util.ArrayList;
import java.util.List;

public class Variants {

    public static List<Board> getPossibleVariant(Board board, boolean xTurn) {
        List<Board> possibleVariants = new ArrayList<Board>();

        char playing = xTurn ? 'x' : 'o';
        char waiting = xTurn ? 'o' : 'x';
        int ySign = xTurn ? -1 : 1;

        for (Piece piece : board.pieces) {

            int xPos = piece.xPos;
            int yPos = piece.yPos;

            if (piece.type == playing) {
                if (board.board[xPos][yPos + ySign] == ' ')
                    possibleVariants.add(GenerateVariant(board, playing, waiting, xPos, yPos, 0, ySign));

                if (board.board[xPos - 1][yPos + ySign] == waiting)
                    possibleVariants.add(GenerateVariant(board, playing, waiting, xPos, yPos, -1, ySign));

                if (board.board[xPos + 1][yPos + ySign] == waiting)
                    possibleVariants.add(GenerateVariant(board, playing, waiting, xPos, yPos, +1, ySign));
            }

        }
        return possibleVariants;
    }

    private static Board GenerateVariant(Board board, char playing, char waiting, int xPos, int yPos, int xSign, int ySign)
    {
        Board b = new Board(board.xTurn);
        for (Piece p : board.pieces) {
            Piece newPiece = new Piece(p.type, p.xPos, p.yPos);

            if (newPiece.xPos == xPos && newPiece.yPos == yPos && newPiece.type == playing) {
                newPiece.xPos = xPos + xSign;
                newPiece.yPos = yPos + ySign;
            }

            b.pieces.add(newPiece);

            if (newPiece.xPos == xPos - 1 && newPiece.yPos == yPos + ySign
                    && newPiece.type == waiting) {
                b.pieces.remove(newPiece);
            }

            b.posPieces();
        }
        return b;
    }
}

