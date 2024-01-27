package Palindromic_Substrings;

import java.util.Arrays;
/*  647. Palindromic Substrings
    Given a string s, return the number of palindromic substrings in it
    A string is a palindrome when it reads the same backward as forward.
    A substring is a contiguous sequence of characters within the string


    Brainstorm
    1. generate all possible substrings
    2. for each substring check if it is a palindrome, using dp
    3. if is a palindrome, add 1 to count, otherwise continue to next substring combination
 */
public class Palindromic_Substrings_647 {
    public static void main(String[] args) {
        String s= "abc";
        System.out.println(countSubstrings(s));
        String s2="aaa";
        System.out.println(countSubstrings(s2));
    }
    public static int countSubstrings(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i],-1);

        int count=0;
        for(int i=0; i<n; i++){
            dp[i][i] = 1;
            for(int j=i; j<n; j++){
                count += substring(s, i, j, dp);
            }
        }
        return count;
    }
    public static int substring(String s, int start, int end, int[][] dp){
        if(start >= end){
            return 1;
        }
        if(dp[start][end] >= 0){
            return dp[start][end];
        }
        if(s.charAt(start) == s.charAt(end)){
            dp[start][end] = substring(s,start+1, end-1, dp);
        }
        else{
            dp[start][end] = 0;
        }
        return dp[start][end];
    }
}
