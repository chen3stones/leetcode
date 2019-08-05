package problem;

/**
 * [12] 数字转罗马数字
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class Integer2Roman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50,  40,  10, 9,   5,  4,   1};
        String[] str = {"M", "CM", "D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
        while (num > 0){
            for(int i = 0;i < values.length;){
                if(num >= values[i]) {
                    sb.append(str[i]);
                    num -= values[i];
                }else {
                    i++;
                }
            }
        }
        return sb.toString();
     }
}
