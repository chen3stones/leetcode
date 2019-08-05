package problem;

import java.util.HashMap;

/**
 * [3]LongestNonRepeatSubString
 * 最长无重复字串
 * 使用map记录字符上一次出现的位置
 */
public class LongestNonRepeatSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        s = s.toLowerCase();
        HashMap<Character,Integer> map = new HashMap<>(32);
        int left = -1,res = 0,n = s.length();
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))) {
                //取重复的最右的位置
                left = Math.max(left,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i);
            //取最长的子串
            res = Math.max(res,i - left);
        }
        return res;
    }
}
