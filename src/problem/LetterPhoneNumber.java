package problem;

import java.util.ArrayList;
import java.util.List;

/**
 * [17] 电话数字转换为字母
 * 采用递归的方式实现
 */
public class LetterPhoneNumber {
    String[][] strings = {{"a","b","c"},{"d","e","f"},{"j","h","i"},
            {"j","k","l"},{"m","n","o"},{"p","q","r","s"},
            {"t","u","v"},{"w","x","y","z"}};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return list;
        }
        doIt(list,"",digits,0);
        return list;
    }
    private void doIt(List<String> list,String character,String digits,int time) {
        if(time == digits.length()){
            list.add(character);
            return;
        }
        int t = digits.charAt(time) - '2';
        for(int i = 0;i < strings[t].length;i++) {
            doIt(list,character + strings[t][i],digits,time+1);
        }
    }
}
