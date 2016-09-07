package DynamicProgramming;

public class RangeSumQueryImmutable {
	private int[] nums;
	
	public RangeSumQueryImmutable(int[] nums) {
		for(int i=1;i<nums.length;i++){
			nums[i]+=nums[i-1];
		}
		this.nums=nums;
	}

	public int sumRange(int i, int j) {
		if(i!=0)	return nums[j]-nums[i-1];
		else	return nums[j];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
