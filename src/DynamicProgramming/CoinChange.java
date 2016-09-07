package DynamicProgramming;

public class CoinChange {
	//bottom-up iteration
	public int coinChange1(int[] coins, int amount) {
	    if(amount<1)    return 0;
	    int sum=0;
	    int[] dp=new int[amount+1];
	    while(++sum<=amount){//NOTICE:不能换成sum++!!
            int min=-1;
            for(int coin:coins)
                if(sum>=coin&&dp[sum-coin]!=-1){
                    int tmp=dp[sum-coin]+1;//bottom-up
                    min=min<0?tmp:(tmp<min?tmp:min);
                }
            dp[sum]=min;
        }
        return dp[amount];
    }
	
	//top-down recursion
	public int coinChange(int[] coins, int amount) {
        if(amount<1)    return 0;
        return helper(coins,amount,new int[amount+1]);
    }
    
    private int helper(int[] coins,int remainder,int[] dp){
        if(remainder<0)     return -1;//invalid solution
        if(remainder==0)    return 0;
        if(dp[remainder]!=0)    return dp[remainder];//overlapping subproblem=>avoid recomputing
        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            int res=helper(coins,remainder-coin,dp);//top-down
            if(res>=0&&res<min)     min=res+1;
        }
        dp[remainder]=(min==Integer.MAX_VALUE)?-1:min;
        return dp[remainder];
    }
}
