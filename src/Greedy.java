public class Greedy {


    public static void main(String[] args) {



    }


    public int maxSubArray(int[] nums) {
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        int ans=sum[0];
        int min=0;
        for(int right=0;right<nums.length;right++){
            if(right==0) sum[right]=nums[right];
            else sum[right]=sum[right-1]+nums[right];
            ans=Math.max(sum[right]-min,ans);
            min=Math.min(min,sum[right]);
        }
        return ans;
    }

}
