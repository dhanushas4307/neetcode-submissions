class Solution {
    public boolean isValidSudoku(char[][] board) {
        //create a each map with each row and col set for that respectively key is representing there row or col or subbox index
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> sub = new HashMap<>();

        // iterate the each row and col in the board and check if that presnet in the set or not if present return flase else add those in to set and return true 

        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(board[r][c] == '.') continue;

                String value = (r/3)+ "," +(c/3);
                if(rows.computeIfAbsent(r, k-> new HashSet<>()).contains(board[r][c])
                || cols.computeIfAbsent(c, k-> new HashSet<>()).contains(board[r][c])
                || sub.computeIfAbsent(value , k-> new HashSet<>()).contains(board[r][c])){
                    return false;
                }
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                sub.get(value).add(board[r][c]);
            }
        }
        return true;
    }
}
