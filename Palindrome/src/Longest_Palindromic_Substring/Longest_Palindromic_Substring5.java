package Longest_Palindromic_Substring;

/*
    https://leetcode.com/problems/longest-palindromic-substring/description/
    Given a string s, return the longest palindromic substring s


    dp[i][j]: s.substring(i, j+1) is a palindrome
    currLen = j-i+1
    maxLen = Math.max(currLen, maxLen)

 */
public class Longest_Palindromic_Substring5 {
    public static void main(String[] args) {
        String s1 = "babad";
        System.out.println(longestPalindrome(s1));
        String s2 = "cbbd";
        System.out.println(longestPalindrome(s2));
    }
    public static String longestPalindrome(String s){
        int maxLen = 1;
        String maxPalindrome = new String();
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // use nxn matrix

        for(int i=0; i<n; i++){
            dp[i][i] = true;
            for(int j=i+1; j<n; j++){
                if((s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1] || j-i <= 2)){ // adjacent palindrome is an edge case
                    dp[i][j] = true;
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        maxPalindrome = s.substring(i, j+1);
                    }
                }
            }
        }
        return  maxPalindrome;

    }
}
