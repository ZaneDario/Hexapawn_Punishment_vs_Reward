import java.util.ArrayList;
import java.util.List;

public class Variants {

    public static List<Board> getPossibleVariant(Board board, boolean xTurn) {
        List<Board> possibleVariants = new ArrayList<Board>();

        char playing = xTurn ? 'x' : 'o';
        char waiting = xTurn ? 'o' : 'x';
        int sign = xTurn ? -1 : 1;

        for (Piece piece : board.pieces) {

            int xPos = piece.xPos;
            int yPos = piece.yPos;

            if (piece.type == playing) {
                if (board.board[xPos][yPos + sign] == ' ') {
                    Board b = new Board(xTurn);

                    for (Piece p : board.pieces) {
                        Piece newPiece = new Piece(p.type, p.xPos, p.yPos);

                        if (newPiece.xPos == xPos && newPiece.yPos == yPos && newPiece.type == playing) {
                            newPiece.yPos = yPos + sign;
                        }

                        b.pieces.add(newPiece);
                        b.posPieces();
                    }

                    possibleVariants.add(b);
                }

                if (board.board[xPos - 1][yPos + sign] == waiting) {
                    Board b = new Board(xTurn);

                    for (Piece p : board.pieces) {
                        Piece newPiece = new Piece(p.type, p.xPos, p.yPos);

                        if (newPiece.xPos == xPos && newPiece.yPos == yPos && newPiece.type == playing) {
                            newPiece.xPos = xPos - 1;
                            newPiece.yPos = yPos + sign;
                        }

                        b.pieces.add(newPiece);

                        if (newPiece.xPos == xPos - 1 && newPiece.yPos == yPos + sign
                                && newPiece.type == waiting) {
                            b.pieces.remove(newPiece);
                        }

                        b.posPieces();
                    }
                    possibleVariants.add(b);
                }

            }

            if (board.board[xPos + 1][yPos + sign] == waiting) {
                Board b = new Board(xTurn);

                for (Piece p : board.pieces) {
                    Piece newPiece = new Piece(p.type, p.xPos, p.yPos);

                    if (newPiece.xPos == xPos && newPiece.yPos == yPos && newPiece.type == playing) {
                        newPiece.xPos = xPos + 1;
                        newPiece.yPos = yPos + sign;
                    }

                    b.pieces.add(newPiece);

                    if (newPiece.xPos == xPos + 1 && newPiece.yPos == yPos + sign
                            && newPiece.type == waiting) {
                        b.pieces.remove(newPiece);
                    }

                    b.posPieces();
                }
                possibleVariants.add(b);
            }
        }
        return possibleVariants;
    }

    //public Board GenerateVariant()
    //{
//
    //}
}

