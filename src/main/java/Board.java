public class Board {
    public String[][] board = new String[3][3];

    public Board()
    {
        for (int i = 0; i < 3; i++) {
            board[0][i] = new Piece("O", i, 0).type;
            board[1][i] = " ";
            board[2][i] = new Piece("X", i, 2).type;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
