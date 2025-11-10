class Solution {
    static public boolean exist(char[][] board, String word) {
for(int row=0;row<board.length;row++){
    for(int col=0;col<board[0].length;col++) {
            if(pathFind(board, word, 0, row, col,new boolean[board.length][board[0].length])) return true;
    }
}
return false;
    }
    static boolean  pathFind(char[][]board, String word, int index, int r, int c, boolean[][]check){
        if(check[r][c]){
            return false;
        }
        if(index==word.length()){
            return true;
        }
        if(board[r][c]==word.charAt(index)){
            if(index==word.length()-1) return true;
check[r][c]=true;
            if(c>0){
                if(pathFind(board,word,index+1,r,c-1,check)) return true;
            }
            if(r>0){
                if(pathFind(board,word,index+1,r-1,c,check))return true;;
            }
            if(r<board.length-1){
                if(pathFind(board,word,index+1,r+1,c,check))return true;
            }
            if(c<board[0].length-1){
                if(pathFind(board,word,index+1,r,c+1,check)) return true;
            }
            check[r][c]=false;
        }
        return false;
    }
}