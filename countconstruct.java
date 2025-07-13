import java.util.HashMap;

public class countconstruct {
    public static int countConstruct(String tar, String[] val, HashMap<String, Integer> memo) {
        if (memo.containsKey(tar)) return memo.get(tar);
        if (tar.isEmpty()) return 1; // Base case: one way to construct an empty string
        int totalCount = 0;
        for (String curr : val) {
            if (tar.startsWith(curr)) {
                String rem = tar.substring(curr.length());
                totalCount += countConstruct(rem, val, memo);
            }
        }
        memo.put(tar, totalCount);
        return totalCount;
    }
    public static void main(String[] args) {
        String target = "abcdef";
        String[] values = {"ab", "abc", "cd", "def", "abcd"};
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println(countConstruct(target, values, memo));   
}

}
