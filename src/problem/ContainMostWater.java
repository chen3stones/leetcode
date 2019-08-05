package problem;

/**
 * [11]装最多的水
 * 容量为为左右边界中的较小值✖️宽度
 * 如果哪边比较低，那么就移动哪边
 */
public class ContainMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int left= 0,right = height.length-1;
        while (left < right){
            result = Math.max(result,Math.min(height[left],height[right]) * (right-left));
            //如果左边比右边的高度低，那么移动左边的边界
            if(height[right] > height[left]) {
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}
