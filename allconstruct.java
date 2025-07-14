import java.util.ArrayList;
import java.util.HashMap;

public class allconstruct {
    public static ArrayList<String> getAllConstructs(String target, String[] wordBank, HashMap<String, ArrayList<String>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        ArrayList<String> result = new ArrayList<>();
        if (target.isEmpty()) {
            result.add("");
            return result;
        }
        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                ArrayList<String> suffixWays = getAllConstructs(suffix, wordBank, memo);
                for (String way : suffixWays) {
                    result.add(word + (way.isEmpty() ? "" : ",") + way);
                }
            }
        }
        memo.put(target, result);
        return result;
    }
    public static void main(String[] args) {
        String target = "abcdef";
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        HashMap<String, ArrayList<String>> memo = new HashMap<>();
        ArrayList<String> allWays = getAllConstructs(target, wordBank, memo);
        for (String way : allWays) {
            System.out.println(way);
        }
        System.out.println("Total ways: " + allWays.size());

        String target2 = "purple";
        String[] wordBank2 = {"purp", "p", "ur", "le", "purpl"};
        HashMap<String, ArrayList<String>> memo2 = new HashMap<>();
        ArrayList<String> allWays2 = getAllConstructs(target2, wordBank2, memo2);
        for (String way : allWays2) {
            System.out.println(way);
        }
        System.out.println("Total ways: " + allWays2.size());
    }
}
