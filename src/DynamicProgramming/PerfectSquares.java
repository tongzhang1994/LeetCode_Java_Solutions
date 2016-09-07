package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {
	
	public int numSquares(int n) {
        //overlapping subproblems & opitimal substructures
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++)
                min=Math.min(dp[i-j*j]+1,min);
            dp[i]=min;
        }
        return dp[n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
