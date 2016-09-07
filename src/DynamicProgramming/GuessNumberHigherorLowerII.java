package DynamicProgramming;

public class GuessNumberHigherorLowerII {
	//top-down Solution
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        return DP(dp,1,n);
    }
    
    private int DP(int[][] dp,int start,int end){
        if(start>=end)  return 0;
        if(dp[start][end]!=0)   return dp[start][end];//overlapping subproblems
        int res=Integer.MAX_VALUE;
        for(int x=start;x<=end;x++){
            int tmp=x+Math.max(DP(dp,start,x-1),DP(dp,x+1,end));//optimal substructures
            res=Math.min(tmp,res);
        }
        dp[start][end]=res;
        return res;
    }
    
    //bottom-up Solution
    public int getMoneyAmount1(int n) {
        int[][] dp=new int[n+2][n+2];//to avoid ArrayIndexOutofBoundException
        for(int len=2;len<=n;len++)//iterate length since the calculations of longer intervals rely on these shorter ones.
            for(int s=1;s+len-1<=n;s++){//iterate interval start positions so that we can calculate all intervals
                dp[s][s+len-1]=Integer.MAX_VALUE;
                for(int x=s;x<=s+len-1;x++){//iterate the picked item x, and minimize the max cost.
                    int tmp=x+Math.max(dp[s][x-1],dp[x+1][s+len-1]);
                    dp[s][s+len-1]=Math.min(dp[s][s+len-1],tmp);
                }
            }
        return dp[1][n];
    }
}
