import java.util.ArrayList;
import java.util.HashMap;

public class canconstruct{
    public static boolean canConstruct(String tar,ArrayList<String> val,HashMap<String, Boolean> memo){
        if (memo.containsKey(tar)) return memo.get(tar);
        if (tar.isEmpty() ) {
            memo.put(tar, true);
            return true;
        }
        for(String curr:val){
            if(tar.startsWith(curr)){
                String rem = tar.substring(curr.length());
                if(canConstruct(rem, val, memo)){
                    memo.put(tar, true);
                    return true;
                }
            }
        }
        memo.put(tar, false);
        return false;

    }
    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<>();
        values.add("ab");
        values.add("abc");
        values.add("cd");
        values.add("def");
        values.add("abcd");
        String target = "abcdef";
        System.out.println(canConstruct(target, values,new HashMap<String, Boolean>()));
    }
}