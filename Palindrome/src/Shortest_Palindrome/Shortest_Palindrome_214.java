package Shortest_Palindrome;
/*
    You are given a string s. You can convert s to a palindrome by adding characters
    in front of it.

    s = "aacecaaa"
    "aaacecaaa"
    s = "abcd"
    "dcbabcd"


    Find the longest palindrome substrings from index 0,
    then place the non-palindrome substring to the front of s

    To find lps, needs a lps[i] that stores the longest palindrome substring ends at index i
    use another currLps to store the curr lps
    for loop iterates all possible ending index i:
        init currLps <- lps[i-1]
        while currLps > 0 and a new string has unequal char at i and currLps
            cannot match a palindrome in this index
            move back to last lps, since currLps starts from index 0, currLps - 1 is last lps

        if new_s[i] == new_s[currLps]
            currLps += 1

        lps[i] = currLps

    longest palindromic substring is reversed part of "len(new_s) - lps[len(new_s)-1]" + s
 */
public class Shortest_Palindrome_214 {
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
        String s2 = "abcd";
        System.out.println(shortestPalindrome(s2));
    }
    public static String shortestPalindrome(String s){
        int n = s.length();
        int currLps = 0;
        String rev_s = reverseString(s);
        String new_s = s + "#" + rev_s;
        int new_n = new_s.length();
        int[] lps = new int[new_n];

        for(int i=1; i<new_n; i++){
            currLps = lps[i-1];

            while(currLps > 0 && new_s.charAt(i) != new_s.charAt(currLps)){
                currLps = lps[currLps-1];
            }
            if(new_s.charAt(currLps) == new_s.charAt(i)){
                currLps += 1;
            }
            lps[i] = currLps;
        }
        return rev_s.substring(0, n-lps[new_n-1]) + s;
    }

    public static String reverseString(String s){
        String rev_s = new String();
        for(int i=s.length()-1; i>=0; i--)
            rev_s += s.charAt(i);
        return rev_s;
    }
}
