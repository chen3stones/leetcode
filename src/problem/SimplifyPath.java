package problem;

import java.util.LinkedList;

/**
 * [71]简化文件路径
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return "/";
        }
        String[] strings = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0;i < strings.length;i++){
            switch (strings[i]){
                case "..":
                    if(list.size() > 0){
                        list.pop();
                    }
                    break;
                case ".":
                    break;
                case "":
                    break;

                    default:
                        list.push(strings[i]);
                        break;
            }
        }
        StringBuilder sb = new StringBuilder("/");
        for(int i = list.size() - 1;i >= 0;i--){
            sb.append(list.get(i));
            sb.append("/");
        }
        if(sb.length() > 1){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
