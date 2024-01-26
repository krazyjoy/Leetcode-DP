package Decode_Ways;

public class Decode_Ways_91 {
    public static int numDecodings(String s){
        // reverse iterating string s
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i+1];
                if(i != n-1){
                    if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i) == '7')){
                        dp[i] += dp[i+2];
                    }
                }
            }

        }
        return dp[0];
    }
}
