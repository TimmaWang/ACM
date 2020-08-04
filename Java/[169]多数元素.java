//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                int num = map.get(nums[i]);
                num++;
                map.put(nums[i], num);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getValue();
//            System.out.println("key="+entry.getKey()+"  value="+entry.getValue());
            if (num > nums.length/2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
