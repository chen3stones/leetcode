package problem;

/**
 * [198] House Robber1
 * 使用动态规划的方式进行处理，
 * 第i个位置的抢劫金额为i-1个位置的
 * 金额和第i-2个位置的金额加上第i家的金额
 * 状态转移函数为 dp[i] = Math.max(dp[i-1],dp[i-2] + num[i])
 * [213] House Robber2
 */
public class RobHouse {
    /**
     * house robber1
     * 动态规划
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1;i < nums.length;++i) {
            dp[i + 1] = Math.max(dp[i],dp[i-1] + nums[i]);
        }
        return dp[nums.length];
    }

    /**
     * 打家劫舍2也是使用动态规划，但是因为首尾相接，因此只能
     * 从0～(n-2)或者1~(n-1)
     * 也就是使用两次打家劫舍1的思路
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp1[] = new int[len + 1];
        int dp2[] = new int[len + 1];
        dp1[0] = 0;
        dp2[0] = 0;
        dp1[1] = nums[0];
        dp2[1] = nums[1];

        for(int i = 1;i < nums.length - 1;++i) {
            dp1[i + 1] = Math.max(dp1[i], dp1[i-1] + nums[i]);
        }
        for(int i = 2;i < nums.length;++i) {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2] + nums[i]);
        }

        return Math.max(dp1[len-1],dp2[len-1]);
    }
}
