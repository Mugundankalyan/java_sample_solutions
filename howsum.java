import java.util.ArrayList;
import java.util.HashMap;

public class howsum {
    public static ArrayList<Integer> howSum(int tar,int[]val,HashMap<Integer, ArrayList<Integer>> memo){
        if(memo.containsKey(tar)) return memo.get(tar);
        if(tar==0) return new ArrayList<>();
        if(tar<0) return null;
        for(int curr:val){
            int rem=tar-curr;
            ArrayList<Integer> result = howSum(rem, val, memo);
            if(result != null){
                ArrayList<Integer> newResult= new ArrayList<>(result);
                newResult.add(curr);
                memo.put(tar, newResult);
                return newResult;
            }
        }
        memo.put(tar,null);
        return null;    
    }
    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}, new HashMap<>()));
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(howSum(7, new int[]{2, 4}, new HashMap<>()));
        System.out.println(howSum(300, new int[]{14, 7}, new HashMap<>()));
    }
}
