package problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * [300] 最长上升子序列
 * 使用方法为动态规划，每一个元素都需要寻找比自己小一名的元素，
 * 因此其时间复杂度为n^2
 * @author chen3stones
 * @date 2019.8.1
 */
public class LongestIncreaseSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null | nums.length == 0) {
            return 0;
        }
        int[] tmp = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            tmp[i] = 1;
            for(int j = 0;j < i;j++){
                if(nums[j] < nums[i]){
                    tmp[i] = Math.max(tmp[i],tmp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            max = Math.max(max,tmp[i]);
        }
        return max;
    }
}
