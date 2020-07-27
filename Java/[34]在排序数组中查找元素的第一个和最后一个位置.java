//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[2];

        int begin = 0;
        int end = nums.length-1;
        int targetIndex = -1;
        while (begin <= end) {
            int mid = (begin+end)/2;
            if (nums[mid] == target) {
                targetIndex =  mid;
                break;
            } else if (nums[mid] < target) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }

        if (targetIndex == -1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int start = targetIndex;
        end = targetIndex;
        while (start >= 0 && nums[start] == target) {
            start--;
        }

        while (end < nums.length && nums[end] == target) {
            end++;
        }

        res[0] = start+1;
        res[1] = end-1;
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
