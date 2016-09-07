package DynamicProgramming;

import java.util.Arrays;

public class MaximalSquare {
	//optimized
	public int maximalSquare1(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int[] prev = new int[matrix[0].length + 1];
        int[] curr = new int[matrix[0].length + 1];
        int res = 0;
        for(int i = 1 ;i <= matrix.length; i++){
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i-1][j-1] == '1') {
                    curr[j] = Math.min(Math.min(curr[j-1],prev[j - 1]), prev[j]) + 1;
                    res = Math.max(res,curr[j]);
                }
                else
                    curr[j] = 0;
            }
            prev = Arrays.copyOf(curr, curr.length);
            Arrays.fill(curr,0);
        }
        return res*res;
    }
	//best solution
	public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)    return 0;
        int[] cur=new int[matrix[0].length+1];
        int upperLeft=0,size=0;
        for(int i=1;i<=matrix.length;i++)
            for(int j=1;j<=matrix[0].length;j++){
                int tmp=cur[j];//stores the value of cur[j] calculated in the lastest iteration.
                if(matrix[i-1][j-1]=='1'){
                    cur[j]=Math.min(Math.min(cur[j-1],upperLeft),tmp)+1;
                    size=Math.max(size,cur[j]);
                }else   cur[j]=0;
                upperLeft=tmp;
            }
        return size*size;
    }
}
