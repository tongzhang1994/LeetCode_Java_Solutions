package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		//prefixing
        List<Integer> res=new LinkedList<Integer>();
        int n=nums.length;
        if(n<1)     return res;
        Arrays.sort(nums);
        int[] dp=new int[n];
        int[] parents=new int[n];
        int size=0,index=0;
        for(int i=nums.length-1;i>=0;i--)
            for(int j=i;j<nums.length;j++){
                if(nums[j]%nums[i]==0&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    parents[i]=j;
                }
                if(dp[i]>size){
                    size=dp[i];
                    index=i;
                }
            }
        while(size-->0){
            res.add(nums[index]);
            index=parents[index];
        }
        return res;
    }
}
