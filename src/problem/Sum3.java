package problem;

import java.util.*;

/**
 * [15] 三个数字之和为0
 * 排序之后时间复杂度为n^2
 * @author chenlei
 * @date 2019.8.1
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i < nums.length-2;i++){
            int j = i + 1,k = nums.length - 1;
            while (j < k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    if(! set.contains(nums[j] + ":" + nums[k])) {
                        List<Integer> numbers = new ArrayList<>();
                        numbers.add(nums[i]);
                        numbers.add(nums[j]);
                        numbers.add(nums[k]);
                        list.add(numbers);
                    }
                    set.add(nums[j] + ":" + nums[k]);
                    j++;
                    k--;
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return list;
    }
}
