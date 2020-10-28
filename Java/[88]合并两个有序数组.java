//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                nums[index] = nums1[p1];
                p1++;
            } else {
                nums[index] = nums2[p2];
                p2++;
            }
            index++;
        }

        while (p1 < m) {
            nums[index] = nums1[p1];
            p1++;
            index++;
        }
        while (p2 < n) {
            nums[index] = nums2[p2];
            p2++;
            index++;
        }

        index = 0;
        while (index < m+n) {
            nums1[index] = nums[index];
            index++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
