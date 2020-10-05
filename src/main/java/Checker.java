public class Checker {

    public void addPossibleMove(Board board, boolean xTurn)
    {
        char playing = xTurn ? 'x' : 'o';
        char waiting = xTurn ? 'o' : 'x';
        int sign = xTurn ? -1 : 1;

        for (Piece piece : board.pieces) {

            int xPos = piece.xPos;
            int yPos = piece.yPos;

            if(piece.type == playing)
            {
                if(board.board[xPos][yPos + sign] ==  ' ')
                {
                    //Add move to the list.
                }

                if(board.board[xPos - 1][yPos + sign] ==  waiting)
                {
                    //Add move to the list.
                }

                if(board.board[xPos + 1][yPos + sign] ==  waiting)
                {
                    //Add move to the list.
                }

                //Update piece position.
            }
        }
    }
}
