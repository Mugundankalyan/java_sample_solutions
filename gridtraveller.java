public class gridtraveller {
    private static int gridTraveller(int m,int n, int[][] memo){
        if(memo[m][n]!=-1) return memo[m][n];
        if(m==0||n==0)return 0;
        if(m==1||n==1)return 1;
        memo[m][n]=gridTraveller(m-1, n, memo)+gridTraveller(m, n-1, memo);
        return memo[m][n];
    }
    public static void main(String[] args) {
        int m = 9;
        int n = 3;
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(gridTraveller(m, n, memo));
    }
}
