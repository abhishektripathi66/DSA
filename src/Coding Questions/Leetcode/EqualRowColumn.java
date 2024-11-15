import java.util.HashMap;

/**

2352. Equal Row and Column Pairs
Solved
Medium
Topics
Companies
Hint
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 
**/


public class EqualRowColumn {

  // My solution
    public int equalPairs(int[][] grid) {
        int count=0;boolean exist=false;

        for(int i=0;i<grid.length;i++){
           int[] row = grid[i]; 
            for(int j=0;j<grid.length;j++){
                exist = false;
                for(int k=0;k<grid.length;k++){
                    if(row[k]==grid[k][j]){
                        exist=true;
                    }else{
                        exist=false;
                        break;
                    }
                }
                if(exist) count++;
                
                

            }
        }
        return count;
    }

  // best solution 
  public int equalPairsbest(int[][] grid) {
        HashMap<Integer,Integer> rowHash=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i <grid.length;i++){
            int hash=rowHashCode(grid[i]);
            rowHash.put(hash,rowHash.getOrDefault(hash,0)+1);
        }
        for(int i=0;i <grid.length;i++){
            int hash=colHashCode(grid,i);
            count=count+rowHash.getOrDefault(hash,0);
        }
        return count;
    }

    public int rowHashCode(int [] row){
        int result =0;

        for(int num : row){
            result = num + result * 5;
        }

        return result;
    }

    public int colHashCode(int [][] grid, int col){
        int result =0;
        for(int i=0; i<grid.length; i++){
            result = grid[i][col] + result *5;
        }
        return result;
    }
}
