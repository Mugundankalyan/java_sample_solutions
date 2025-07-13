import java.util.HashMap;
import java.util.ArrayList;
public class bestsum {
    public static ArrayList<Integer> bestSum(int tar,int[] val,HashMap<Integer,ArrayList<Integer>>memo ){
        if(memo.containsKey(tar)) return memo.get(tar);
        if(tar==0) return new ArrayList<>();
        if(tar<0) return null;
        ArrayList<Integer> bestCombination = null;
        for(int curr:val){
            int rem = tar - curr;
            ArrayList<Integer> result = bestSum(rem, val, memo);
            if(result != null){
                ArrayList<Integer> newCombination = new ArrayList<>(result);
                newCombination.add(curr);
                if(bestCombination == null || newCombination.size() < bestCombination.size()){
                    bestCombination = newCombination;
                }
            }
        }
        memo.put(tar, bestCombination);
        return bestCombination;
    }
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(bestSum(8, new int[]{2, 3, 5}, new HashMap<>()));
        System.out.println(bestSum(8, new int[]{1, 4, 5}, new HashMap<>()));
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}, new HashMap<>()));
    }
}
