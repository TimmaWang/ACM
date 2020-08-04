//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int maxP[] = new int[n];
        int minP[] = new int[n];
        maxP[0] = nums[0];
        minP[0] = nums[0];
        int res = maxP[0];

        for (int i = 1; i< n; i++) {
            maxP[i] = max(maxP[i-1]*nums[i], nums[i], minP[i-1]*nums[i]);
            minP[i] = min(maxP[i-1]*nums[i], nums[i], minP[i-1]*nums[i]);
            if (res < maxP[i]) {
                res = maxP[i];
            }
        }

        return res;

    }


    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b,c));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
