package problem;

/**
 * [6] ZigZag Conversion
 * Z字变换
 * 使用的方法为模拟
 */
public class ZConvert {
    public String convert(String s, int numRows) {
        if(s == null || "".equals(s) || numRows == 1){
            return s;
        }
        int i = 0,len = (numRows-1) * 2;
        StringBuilder[] sb = new StringBuilder[len];
        for(int tmp = 0;tmp < numRows;tmp++){
            sb[tmp] = new StringBuilder("");
        }
        while (i < s.length()){
            int time = 0;
            //方向向下
            while (time < numRows && i < s.length()){
                sb[time].append(s.charAt(i));
                i++;
                time++;
            }
            time = 0;
            //方向向上
            while (time < numRows-2 && i < s.length()){
                sb[numRows-time-2].append(s.charAt(i));
                i++;
                time++;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int n = 0;n < sb.length;n++){
            if(sb[n] != null){
                res.append(sb[n]);
            }
        }
        return res.toString();
    }
}
