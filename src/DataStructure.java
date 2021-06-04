public class DataStructure {
    int[][] board =
            {{0, 2, 0, 2, 0, 2, 0, 2, 0, 2},
                    {2, 0, 2, 0, 2, 0, 2, 0, 2, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 1, 0}};

    public DataStructure() {
    }

    // getters
    public int[][] getDataStructure() {
        return board;
    }
    public int getElement(int x, int y) {
        return board[x][y];
    }

    //setters
    public void setBoard(int[][] board) {
        this.board = board;
    }
    public void setElement(int x, int y, int value) {
        board[x][y]=value;
    }
}
