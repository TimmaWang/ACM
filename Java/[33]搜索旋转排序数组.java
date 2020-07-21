//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {

        return notCommonBinary(nums, 0, nums.length-1, target);

    }

    public int notCommonBinary(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start+end)/2;
        if (nums[mid] == target){
            return mid;
        }

        if (nums[start] < nums[mid] && nums[mid] < nums[end]) {
            return binarySearch(nums, start, end, target);
        } else if (nums[start] < nums[mid]) {
            int indexLeft = binarySearch(nums, start, mid-1, target);
            int indexRight = notCommonBinary(nums, mid+1, end, target);
            if (indexLeft != -1) {
                return indexLeft;
            } else if (indexRight != -1) {
                return indexRight;
            } else {
                return -1;
            }
        } else {
            int indexLeft = notCommonBinary(nums, start, mid-1, target);
            int indexRight = binarySearch(nums, mid+1, end, target);
            if (indexLeft != -1) {
                return indexLeft;
            } else if (indexRight != -1) {
                return indexRight;
            } else {
                return -1;
            }
        }


    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start+end)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid+1, end, target);
        } else {
            return binarySearch(nums, start, mid-1, target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
