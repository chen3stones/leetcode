package problem;

import java.util.ArrayList;
import java.util.List;

/**
 * [93]复原IP地址
 * 使用的是递归的思想
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12){
            return list;
        }
        doIt(list,"",s,0);
        return list;
    }

    /**
     * 使用递归来获取符合条件的IP
     * @param list 用于存储结果
     * @param used 用于保存生成的IP
     * @param left 用于保存剩余的IP
     * @param time 用于记录第几段IP地址
     */
    private void doIt(List<String> list,String used,String left, int time) {
        if(time == 3) {
            if(isValid(left)) {
                used = used + left;
                list.add(used);
            }
            return;
        }
        for(int i = 1;i < 4 && i < left.length();i++) {
            String s = left.substring(0,i);
            if(isValid(s)) {
                doIt(list,used + left.substring(0,i) + ".",left.substring(i),time+1);
            }
        }
    }

    private boolean isValid(String s) {
        int i = Integer.valueOf(s);
        return (i >= 0 && i <= 255 && (s.length() == 1 || s.charAt(0) != '0'));
    }
}
