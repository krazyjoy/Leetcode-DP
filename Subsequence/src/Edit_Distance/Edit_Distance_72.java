package Edit_Distance;
/*
    72. Edit Distance
    Given two strings word1 and word2, return the minimum number of
    operations required to convert word1 to word2

    You have the following three operations permitted on a word
    - insert a char
    - delete a char
    - replace a char


    dp[i][j]: the min number of operations word1[:i] == word2[:j]
        - insert: use word1[:i-1], word2[:j]
        - delete: use word1[:i], word2[:j-1]
        - replace: use word1[:i-1], word2[:j-1]

 */
public class Edit_Distance_72 {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));

        word1 = "intention";
        word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }
    public static int minDistance(String word1, String word2){
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

        /*
            base case:
            word1 == null and word2 == null ---> 0
            word1 == null but word2 != null ---> len(word2)
            word1 != null but word2 == null ---> len(word1)
         */
        for(int i=0; i<= n1; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<= n2; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<= n1; i++){
            for(int j=1; j<=n2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i-1][j];
                    int delete = dp[i][j-1];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = Math.min(replace, Math.min(insert, delete)) + 1;
                }
            }
        }
        return dp[n1][n2];

    }
}
