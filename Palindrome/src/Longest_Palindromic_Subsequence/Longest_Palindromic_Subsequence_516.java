package Longest_Palindromic_Subsequence;

import java.util.Arrays;

/*
    Given a string s, find the longest palindromic subsequence's length in s

 */
public class Longest_Palindromic_Subsequence_516 {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
        String s2 = "cbbd";
        System.out.println(longestPalindromeSubseq(s2));
    }
    public static int longestPalindromeSubseq(String s){
        int n = s.length();
        if(n <= 1)
            return 1;
        String rev_s = reverseString(s);
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == rev_s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }

    public static String reverseString(String s){
        String rev_s = new String();
        for(int i=s.length()-1; i>=0; i--)
            rev_s += s.charAt(i);
        return rev_s;
    }
}
