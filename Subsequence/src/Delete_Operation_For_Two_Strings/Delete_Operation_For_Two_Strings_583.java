package Delete_Operation_For_Two_Strings;
/*
    583. Delete Operation for Two Strings
    https://leetcode.com/problems/delete-operation-for-two-strings/description/

    base case: word1 == null and word2 == null -> 0 deletions
               word1 == null but word2 != null -> remove all word2 char -> len(word2) - j
               word1 != null but word2 == null -> remove all word1 char -> len(word1)- i
 */
public class Delete_Operation_For_Two_Strings_583 {
    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        System.out.println(minDistance(word1, word2));

        word1 = "leetcode";
        word2 = "etco";
        System.out.println(minDistance(word1, word2));

    }
    public static int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
                }
            }
        }
        return dp[n][m];
    }
}
