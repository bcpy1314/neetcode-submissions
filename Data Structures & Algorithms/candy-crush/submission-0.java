class Solution {
    int m;
    int n;
    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        Set<Pair<Integer, Integer>> crushedSet = find(board);
        while( !crushedSet.isEmpty()){
            crush(crushedSet, board);
            drop (board);
            crushedSet = find(board);
        }
        return board;
        
    }

    public Set<Pair<Integer, Integer>> find(int[][] board){
        Set<Pair<Integer, Integer>> crushedSet = new HashSet<>();
       
        // check vertically adjacent candies
        for (int r = 1; r < m - 1; r++){
            for(int c = 0; c < n; c++ ){
                if (board[r][c] == 0){
                    continue;
                }
                if (board[r][c] == board[r-1][c] && board[r][c] == board[r+1][c]){
                    crushedSet.add(new Pair<>(r, c));
                    crushedSet.add(new Pair<>(r-1, c));
                    crushedSet.add(new Pair<>(r+1, c));
                }
            }
        }
        // check horizontally
        for (int c = 1; c < n -1; c++){
            for (int r = 0; r < m; r++){
                if (board[r][c] == 0){
                    continue;
                }
                if (board[r][c] == board[r][c-1] && board[r][c] == board[r][c+1]){
                    crushedSet.add(new Pair<>(r,c));
                    crushedSet.add(new Pair<>(r, c + 1));
                    crushedSet.add(new Pair<>(r, c-1));
                }
            }
        }
        return crushedSet;
    }

    public void crush (Set<Pair<Integer, Integer>> set, int[][] board){
        if(set.size()<=0){
            return;
        }
        for (Pair<Integer, Integer> p: set){
            int r = p.getKey();
            int c = p.getValue();
            board[r][c] = 0;
        }
    }

    public void drop (int[][] board){
        //for each column drop candies down vertically
        for (int c = 0; c < n; c++){
            int lowestZero = m - 1;
            for (int r = m - 1; r >= 0; r--){
                if (board[r][c] != 0){
                    board[lowestZero][c] = board[r][c];
                    if (lowestZero != r){
                        board[r][c] = 0;
                    }
                    lowestZero--;
                }
            }
        }
    }
}