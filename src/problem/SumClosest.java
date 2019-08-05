package problem;

import java.util.Arrays;

/**
 * [16] 三数之和与目标最近
 * 双指针法，主要注意的是分析两个指针分别应该在什么时候开始移动，
 * 在装最多水的题目中是移动矮的一根柱子
 * 在这个题目和【15】的题目中是让和与目标比较
 * 如果和太大那么让高的一端移动，如果太小那么让小的一端移动
 */
public class SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0,tmp = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length-2;i++){
            int j = i + 1,k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                int t = Math.abs(target - s);
                if(t < tmp){
                    tmp = t;
                    sum = s;
                }
                if(s < target) {
                    j++;
                }else{
                    k--;
                }
            }
        }
        return sum;
    }
}
