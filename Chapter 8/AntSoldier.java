import java.util.*;

public class AntSoldier {
	static int[] d = new int[30001];
	public static void main(String[] args) {
		int[] donations = {1,3,1,5};
        int ans = 0;
        int N = donations.length;
        int[] dp = new int[N];
        
        for (int i = 0; i < N-1; i++) {
			dp[i] = donations[i];
			if(i>0) dp[i] = Math.max(dp[i], dp[i-1]);
			if(i>1) dp[i] = Math.max(dp[i], dp[i-2] + donations[i]);
			ans = Math.max(ans, dp[i]);
		}
        
        for (int i = 0; i < N-1; i++) {
			dp[i] = donations[i+1];
			if(i>0) dp[i] = Math.max(dp[i], dp[i-1]);
			if(i>1) dp[i] = Math.max(dp[i], dp[i-2]+donations[i+1]);
			ans = Math.max(ans, dp[i]);
		}
        System.out.println(ans);
	}
}

