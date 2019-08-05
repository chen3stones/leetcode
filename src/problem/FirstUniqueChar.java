package problem;

/**
 * [387]第一次出现的非重复字符
 * 直接使用遍历的方式就
 * 最好的使用的java库里面的index方法实现的
 */
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        int[][] tmp = new int[26][2];
        for(int i = 0;i < s.length();i++){
            int t = s.charAt(i) - 'a';
            tmp[t][0]++;
            tmp[t][1] = i;
        }
        for(int i = 0;i < s.length();i++) {
            int t = s.charAt(i) - 'a';
            if(tmp[t][0] == 1){
                return tmp[t][1];
            }
        }
        return -1;
    }
}
