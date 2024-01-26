package Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/*
    https://leetcode.com/problems/generate-parentheses/description/
    Given n pairs of parentheses, write a function to generate all combinations of
    well-formed parentheses

    brainstorm:
        use left keep track of the number of left parenthesis
        use right ...                        right ...
        if(left > right) need to append right parenthesis until right == left
 */
public class Generate_Parentheses_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<>();
        helper(n, n, new String(), ans);
        return ans;
    }

    public static void helper(int left, int right, String s, List<String> ans){
        if(left == 0 && right == 0){
            ans.add(s);
            return;
        }

        if(left != 0){
            helper(left-1, right, s+"(", ans);
        }
        if(left < right){

            helper(left, right-1, s+")", ans);
        }

    }
}
