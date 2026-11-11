class Solution {
    public int[][] candyCrush(int[][] board) {
        // use a boolean[][] to store whether it's same
        int row = board.length;
        int col = board[0].length;

        boolean[][] shouldCrush = findCrush(board);
        while (needCrush(shouldCrush)){
            crush(shouldCrush, board);
            drop(board);
            shouldCrush = findCrush(board);
        }
        return board;
          
    }
    public boolean needCrush(boolean[][] shouldCrush){
        for (boolean[] row: shouldCrush){
            for (boolean x: row){
                if(x){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean[][] findCrush(int[][] board){
        int row = board.length;
        int col = board[0].length;

        boolean[][] shouldCrush = new boolean[row][col];
        for(int i = 1; i < row - 1; i++){
            for (int j = 0; j < col; j++){
                int val = board[i][j];
                if (val != 0 && board[i-1][j] == val && board[i+1][j] == val){
                    shouldCrush[i][j] = true;
                    shouldCrush[i-1][j] = true;
                    shouldCrush[i+1][j] = true;
                }
            }
        } 

        for ( int j = 1; j < col -1; j++){
            for (int i = 0; i < row; i++){
                int val = board[i][j];
                if (val != 0 && board[i][j-1] == val && board[i][j+1] == val){
                    shouldCrush[i][j] = true;
                    shouldCrush[i][j -1] = true;
                    shouldCrush[i][j+ 1] = true;
                }
            }
        }
        return shouldCrush;
    }

    public void crush(boolean[][] shouldCrush, int[][] board){
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++ ){
            for(int j = 0; j < col; j++){
                if (shouldCrush[i][j]){
                    board[i][j] = 0;
                }
            }
        }
    }

    public void drop(int[][] board){
        int row = board.length;
        int col = board[0].length;
        for (int c = 0; c < col; c++){
            int lowestZero = row -1;
            for (int i = row -1; i >= 0; i--){
                if (board[i][c] != 0){
                    board[lowestZero][c] = board[i][c];
                    lowestZero--;
                }
            }
            while( lowestZero >= 0){
                board[lowestZero][c] = 0;
                lowestZero --;
            }
        }
    }
}
