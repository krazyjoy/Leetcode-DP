package Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

/*
    https://leetcode.com/problems/palindrome-partitioning/description/
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s


    The return all possible palindrome seemed very backtracking
    Use a separate function to check if in a certain range, a substring is a palindrome, then add to a temp list
    if the string is traversed entirely and can be partition to several palindromes, then add to the largest list

 */
public class Palindrome_Partitioning_131 {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }


    public static List<List<String>> partition(String s){
        List<List<String>> palindromes = new ArrayList<>();
        backtrack(palindromes, new ArrayList<>(), s, 0);
        return palindromes;
    }
    public static void backtrack(List<List<String>> palindromes, List<String> palindrome, String s, int start){
        if(start == s.length()){
            palindromes.add(new ArrayList<>(palindrome));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                palindrome.add(s.substring(start, i+1));
                backtrack(palindromes, palindrome, s, i+1);
                palindrome.remove(palindrome.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high){
        if(low > high){
            return false;
        }

        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low += 1;
            high -= 1;
        }
        return true;
    }
}
