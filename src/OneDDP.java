public class OneDDP {

    public static void main(String[] args) {




    }
    //Climbing Stairs
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i = 2; i<n;i++) dp[i] = dp[i-1]+dp[i-2];
        return dp[n-1];
    }

    //Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[dp.length-1] = cost[cost.length-1];
        dp[dp.length-2] = cost[cost.length-2];
        for(int i=dp.length-3;i>=0;i--){
            dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }

}
