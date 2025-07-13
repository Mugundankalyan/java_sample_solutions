import java.util.HashMap;

public class cansum{
    private static boolean canSum(int tar,int[] arr,HashMap<Integer, Boolean> memo){
        if(memo.containsKey(tar)) return memo.get(tar);
        if(tar==0) return true;
        if(tar<0) return false;
        for(int curr:arr){
            int rem=tar-curr;
            if(canSum(rem, arr, memo)){
                memo.put(rem,true);
                return true;
            }
        }
        memo.put(tar,false);
        return false;
    }
    public static void main(String[] args) {
        
        System.out.println(canSum(7,new int[]{2,3},new HashMap<>()));
        System.out.println(canSum(7,new int[]{5,3,4,7},new HashMap<>()));
        System.out.println(canSum(7,new int[]{2,4},new HashMap<>()));
        System.out.println(canSum(300,new int[]{14,7},new HashMap<>()));
    }
}