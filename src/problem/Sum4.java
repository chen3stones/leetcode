package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 【18】4数相加为目标
 */
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>  list = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return list;
        }
        Arrays.sort(nums);
        int a = 0, b, c ,d = nums.length - 1;
        HashSet<String> set = new HashSet<>();
        while (a < d) {
            b = a + 1;
            c = d - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c] + nums[d];
                String s = new StringBuilder().append(nums[a]).append(",").append(nums[b]).append(",").append(nums[c])
                        .append(",").append(nums[d]).toString();
                if(sum == target && !set.contains(s)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[a]);
                    tmp.add(nums[b]);
                    tmp.add(nums[c]);
                    tmp.add(nums[d]);
                    list.add(tmp);
                    set.add(s);
                    b++;
                    c--;
                }
                if(sum < target){
                    b++;
                }else if(sum > target){
                    c--;
                }
            }
            int sum = nums[a] + nums[b] + nums[c] + nums[d];
            if(sum < target){
                a++;
            }else if(sum > target){
                d--;
            }
        }
        return list;
    }
}
