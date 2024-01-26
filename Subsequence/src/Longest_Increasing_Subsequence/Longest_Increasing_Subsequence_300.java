package Longest_Increasing_Subsequence;

import java.util.Arrays;

/*
    300. Longest Increasing Subsequence
    https://leetcode.com/problems/longest-increasing-subsequence/description/

    if(nums[i] < nums[end])
        dp[end] <= dp[i] + 1

 */
public class Longest_Increasing_Subsequence_300 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,2,3};
        int[] case1 = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(case1));
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int result=0;
        for(int i=0; i<n; i++){
            result = Math.max(result, dp[i]);
        }

        return result;

    }

}
