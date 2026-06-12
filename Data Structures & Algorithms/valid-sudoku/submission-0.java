class Solution {
    public boolean isValidSudoku(char[][] board) {

        // create a set for each row or column or sqaure
        for (int row = 0; row < 9; row ++){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++){
                if (board[row][i] == '.'){
                    continue;
                }
                if (set.contains(board[row][i])){
                    return false;
                }
                set.add(board[row][i]);
            }
        }
        
        for (int column = 0; column < 9; column ++){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i ++){
                if (board[i][column] == '.'){
                    continue;
                }
                if (set.contains(board[i][column])){
                    return false;
                }
                set.add(board[i][column]);
            }
        }

        for (int square = 0; square < 9; square++){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i ++){
                for (int j = 0; j < 3; j ++){
                    int row = (square / 3) * 3 + i;
                    int column = ( square % 3) * 3 + j;
                    if (board[row][column] == '.'){
                        continue;
                    }
                    if(set.contains(board[row][column])){
                        return false;
                    }
                    set.add(board[row][column]);
                }
            }
        }
        return true;
    }
}
