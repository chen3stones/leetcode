package problem;

/**
 * [8]字符串转integer
 * 在这个问题中需要注意的是如果使用integer和long都会出现
 * 溢出的情况，因此需要使用字符串的长度进行判断
 * 在判断的时候主要要剔除掉开头为0的情况
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null || str.trim().length() == 0){
            return 0;
        }
        str = str.trim();
        //用该标志标记是否为负数
        boolean lowZero = false;
        int start = 0,len = 10;
        StringBuilder stringBuilder = new StringBuilder();
        if(str.charAt(0) == '+'){
            start = 1;
        } else if(str.charAt(0) == '-'){
            lowZero = true;
            start = 1;
        }

        //剔除开头为0的情况
        while (start < str.length()) {
            if(str.charAt(start) == '0'){
                start++;
            }else{
                break;
            }
        }

        while (start < str.length()){
            if(stringBuilder.length() >= len){
                break;
            }
            char c = str.charAt(start);
            if(c >= '0' && c <= '9'){
                stringBuilder.append(c);
                start++;
            }else{
                break;
            }
        }

        Long tmp;
        //为了避免stringBuilder为空的情况出现exception
        if(stringBuilder.length() ==0){
            tmp = 0L;
        }else{
            tmp = Long.valueOf(stringBuilder.toString());
        }
        if(lowZero){
            if(tmp >= Integer.MAX_VALUE + 1L){
                return Integer.MIN_VALUE;
            }else{
                return tmp.intValue();
            }
        }else {
            if(tmp > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return tmp.intValue();
            }
        }
    }
}
