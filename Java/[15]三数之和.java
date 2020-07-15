//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <=2) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int first = 0 ; first < n-2; first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int third = n-1;
            for (int second = first+1; second < n-1; second++) {
                if (second > first+1 && nums[second] == nums[second-1]) {
                    continue;
                }

                while (third > second && nums[first]+nums[second]+nums[third] > 0) {
                    third--;
                }

                // TODO: 2020-07-15 这一步骤的用途，去理解
                if (second == third) {
                    break;
                }

                if (nums[first]+nums[second]+nums[third] == 0) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[first]);
                    cur.add(nums[second]);
                    cur.add(nums[third]);
                    res.add(cur);
                }
            }
        }


        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
