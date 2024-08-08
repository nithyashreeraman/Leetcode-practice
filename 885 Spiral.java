// You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

// You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

// Return an array of coordinates representing the positions of the grid in the order you visited them.
// Input: rows = 5, cols = 6, rStart = 1, cStart = 4
// Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],
// [3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],
// [2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
         int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}}; //Right down left up
         //right increase j
        //  down increase i
        //  left decrease j
        //  up decrease i
        int n = rows*cols;
        int result[][] = new int[n][2];
        result[0][0] = rStart;  //given in question
        result[0][1] = cStart;
        int count=1;
        int step=1;
        int index=0;
        

        // R -> 1
        // D -> 1
        // L -> 2      this is the pattern for changing direction
        // U -> 2
        // R -> 3
        // D -> 3
        // L -> 4
        // U -> 4

        while(count<n){
            for(int times=0;times<2;times++){    //only 2 times the step repeats (R,D)
                int dr = directions[index%4][0];
                int dc = directions[index%4][1];
                for(int i=0;i<step;i++){  // step should increase - 1,1,2,2,3,3
                    rStart+=dr;
                    cStart+=dc;
                    if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                        result[count][0] = rStart;
                        result[count][1] = cStart;
                        count++;
                    }
                }
                index++;
            }
            step++;
        }
        return result;
    }
}